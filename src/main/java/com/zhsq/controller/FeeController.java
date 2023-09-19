package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.zhsq.context.BaseContext;
import com.zhsq.mapper.FeeMapper;
import com.zhsq.pojo.Fee;
import com.zhsq.pojo.Owner;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.UserAddress;
import com.zhsq.pojo.dto.FeeDetailDTO;
import com.zhsq.pojo.dto.FeePayDTO;
import com.zhsq.pojo.vo.FeePageVO;
import com.zhsq.pojo.vo.FeeVO;
import com.zhsq.service.FeeService;
import com.zhsq.utils.DateUtils;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 费用(Fee)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/fees")
public class FeeController {
    /**
     * 服务对象
     */
    @Autowired
    private FeeService feeService;
    @Autowired
    private FeeMapper feeMapper;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Fee>> getAllByPage(int page, int size){
   	Page<Fee> feePage = new Page<>(page, size);
   	LambdaQueryWrapper<Fee> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   	//执行查询
   	feeService.page(feePage);
   	return R.success(feePage);
   }
   @GetMapping("/dayfees")
   public Result<FeeVO> feeVOResult(
           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dayTime){
       Integer currentId = BaseContext.getCurrentId();
       log.info("费用查询时间{}，当前用户id：{}",dayTime,currentId);
       FeeVO feeVO=feeService.getByTime(dayTime,currentId);
       BaseContext.removeCurrentId();
       return Result.success(feeVO);
   }
   /*
   * 费用查询，带有分页*/
   @GetMapping("/detailpage")
    public Result<FeePageVO> pageFee(
           @RequestParam(defaultValue = "1") Integer page,
           @RequestParam(defaultValue = "4") Integer pageSize,
           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime detailTime,
           Integer feeType
   ){
       log.info("费用查询：");
       Integer currentId = BaseContext.getCurrentId();
       FeePageVO feePageVO=feeService.getByAll(page,pageSize,detailTime,feeType,currentId);
       BaseContext.removeCurrentId();
        return Result.success(feePageVO);
    }
   @GetMapping("/detail")
   public Result<List<FeeDetailDTO>> feeDetail(
           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime detailTime,
           Integer feeType
   ){
       log.info("feeType:{}",feeType);
       Integer currentId = BaseContext.getCurrentId();
       log.info("查询时间：{}，费用类型：{},当前操作用户id：{}",detailTime,feeType,currentId);
       List<FeeDetailDTO> feeDtail=feeService.getDetailByTimeAndType(detailTime,feeType,currentId);
       BaseContext.removeCurrentId();
       return Result.success(feeDtail);
   }
   /*
   * 用户缴费实现*/
    @PostMapping("/payment")
    public Result<Fee> payment(@RequestBody FeePayDTO feePayDTO){
        Double fee = feePayDTO.getFee();
        Integer feeType = feePayDTO.getFeeType();
        String companyId = feePayDTO.getCompanyId();
        String ownerId = feePayDTO.getOwnerId();
        log.info("费用：{}，类型：{}，公司：{}，用户：{}",fee,feeType,companyId,ownerId);
        if(feePayDTO.getFee()==null){
            return Result.error("缴费失败");
        }
        Owner one = Db.lambdaQuery(Owner.class).eq(Owner::getOwnerId, ownerId).one();
        if (one==null){
            return Result.error("缴费编号不存在");
        }
        Integer currentId = BaseContext.getCurrentId();
        feePayDTO.setPayTime(DateUtils.toDate(LocalDateTime.now()));
        feePayDTO.setUserId(currentId);
        log.info("用户缴费：{},当前用户id：{}",feePayDTO,currentId);
        Fee feeMsg=feeService.userPayment(feePayDTO);
        BaseContext.removeCurrentId();
        return Result.success("支付成功",feeMsg);
    }
    /*
    * 根据业主的id查询对应信息*/

}
