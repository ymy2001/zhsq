package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.ParkingSpace;
import com.zhsq.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
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
}
