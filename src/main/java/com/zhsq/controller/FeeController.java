package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.context.BaseContext;
import com.zhsq.pojo.Fee;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.dto.FeeDetailDTO;
import com.zhsq.pojo.dto.FeePayDTO;
import com.zhsq.pojo.vo.FeeVO;
import com.zhsq.service.FeeService;
import com.zhsq.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
   @GetMapping("/detail")
   public Result<List<FeeDetailDTO>> feeDetail(
           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime detailTime,
           Integer feeType
   ){
       Integer currentId = BaseContext.getCurrentId();
       log.info("查询时间：{}，费用类型：{},当前操作用户id：{}",detailTime,feeType,currentId);
       List<FeeDetailDTO> feeDtail=feeService.getDetailByTimeAndType(detailTime,feeType,currentId);
       return Result.success(feeDtail);
   }
   /*
   * 用户缴费实现*/
    @PostMapping("/payment")
    public Result<Fee> payment(@RequestBody FeePayDTO feePayDTO){
        Integer currentId = BaseContext.getCurrentId();
        feePayDTO.setPayTime(DateUtils.toDate(LocalDateTime.now()));
        feePayDTO.setUserId(currentId);
        log.info("用户缴费：{},当前用户id：{}",feePayDTO,currentId);
        Fee feeMsg=feeService.userPayment(feePayDTO);
        BaseContext.removeCurrentId();
        return Result.success("支付成功",feeMsg);
    }
}
