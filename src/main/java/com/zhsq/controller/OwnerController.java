package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Owner;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.vo.FeeOwnerVO;
import com.zhsq.service.OwnerService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * 业主表(Owner)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/owners")
public class OwnerController {
    /**
     * 服务对象
     */
    @Autowired
    private OwnerService ownerService;
    /*
    * 业主信息查询*/
    @GetMapping("/msg")
    public Result<FeeOwnerVO> owner(String ownerId){
        log.info("业主信息查询：{}",ownerId);
        FeeOwnerVO fv=new FeeOwnerVO();
        LambdaQueryWrapper<Owner> lqw=new LambdaQueryWrapper<Owner>()
                .eq(Owner::getOwnerId,ownerId);
        Owner one = ownerService.getOne(lqw);
        BeanUtils.copyProperties(one,fv);
        return Result.success(fv);
    }

     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Owner>> getAllByPage(int page, int size){
   	Page<Owner> ownerPage = new Page<>(page, size);
   	LambdaQueryWrapper<Owner> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   
   	//执行查询
   	ownerService.page(ownerPage);
   	return R.success(ownerPage);
   }
}
