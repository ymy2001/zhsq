package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.ParkingSpace;
import com.zhsq.pojo.Result;
import com.zhsq.service.ParkingSpaceService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 停车位表(ParkingSpace)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/parkingSpaces")
public class ParkingSpaceController {
    /**
     * 服务对象
     */
    @Autowired
    private ParkingSpaceService parkingSpaceService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<ParkingSpace>> getAllByPage(int page, int size){
   	Page<ParkingSpace> parkingSpacePage = new Page<>(page, size);
   	LambdaQueryWrapper<ParkingSpace> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO 查询条件定制
   
   	//执行查询
   	parkingSpaceService.page(parkingSpacePage);
   	return R.success(parkingSpacePage);
   }
   /*
   * 获取停车场数据*/
    @GetMapping
   public Result<List<ParkingSpace>> getUse(){
       log.info("停车场车位查询");
        List<ParkingSpace> list = parkingSpaceService.list();
        return Result.success(list);
   }
}
