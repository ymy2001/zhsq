package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.mapper.HospitalMapper;
import com.zhsq.pojo.Hospital;
import com.zhsq.service.HospitalService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private HospitalMapper hospitalMapper;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Hospital>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "5") int pageSize,
           String address){
     log.info("社区医院查询:{}",address);
     long total = hospitalService.count();
     //执行查询
     LambdaQueryWrapper<Hospital> queryWrapper=new LambdaQueryWrapper<Hospital>()
             .like(address!=null,Hospital::getAddress,address)
             .or(address!=null)
             .like(address!=null,Hospital::getHospitalName,address);
     Page<Hospital> hospitalPage = new Page<>(page, pageSize, total);
     List<Hospital> hospitalList = hospitalMapper.selectPage(hospitalPage, queryWrapper).getRecords();
     hospitalPage.setRecords(hospitalList);
     return R.success(hospitalPage, total);
   }
}
