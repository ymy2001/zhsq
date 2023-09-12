package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Hospital;
import com.zhsq.service.HospitalService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 医院表(Hospital)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/hospitals")
public class HospitalController {
    /**
     * 服务对象
     */
    @Autowired
    private HospitalService hospitalService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Hospital>> getAllByPage(int page, int size){
   	Page<Hospital> hospitalPage = new Page<>(page, size);
   	LambdaQueryWrapper<Hospital> queryWrapper = new LambdaQueryWrapper<>();
   
   	//执行查询
   	hospitalService.page(hospitalPage);
   	return R.success(hospitalPage);
   }
}
