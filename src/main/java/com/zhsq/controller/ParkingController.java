package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.context.BaseContext;
import com.zhsq.pojo.Parking;
import com.zhsq.pojo.Result;
import com.zhsq.service.ParkingService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
 
/**
 * 停车位表(Parking)表控制层
 *
 * @author makejava
 * @since 2023-09-26 14:47:41
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/parkings")
public class ParkingController {
    /**
     * 服务对象
     */
    @Autowired
    private ParkingService parkingService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Parking>> getAllByPage(int page, int size){
   	Page<Parking> parkingPage = new Page<>(page, size);
   	LambdaQueryWrapper<Parking> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   
   	//执行查询
   	parkingService.page(parkingPage);
   	return R.success(parkingPage);
   }

   /*
   * 车位信息查询*/
    @GetMapping
    public Result<List<Parking>> getMsg(Integer type){
        log.info("车位信息查询：{}",type);
        Integer currentId = BaseContext.getCurrentId();
        LambdaQueryWrapper<Parking> lqw=new LambdaQueryWrapper<>();
        lqw
                .eq(Parking::getParkingStatus,type);
        List<Parking> list = parkingService.list(lqw);
        BaseContext.removeCurrentId();
        return Result.success(list);
    }
}
