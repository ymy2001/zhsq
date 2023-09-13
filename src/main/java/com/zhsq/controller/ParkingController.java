package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Parking;
import com.zhsq.service.ParkingService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
/**
 * 停车位表(Parking)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
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
   	//TODO 查询条件定制
   
   	//执行查询
   	parkingService.page(parkingPage);
   	return R.success(parkingPage);
   }
}
