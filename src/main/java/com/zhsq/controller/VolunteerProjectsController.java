package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.VolunteerProjects;
import com.zhsq.service.VolunteerProjectsService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
/**
 * 志愿项目表(VolunteerProjects)表控制层
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/volunteerProjectss")
public class VolunteerProjectsController {
    /**
     * 服务对象
     */
    @Autowired
    private VolunteerProjectsService volunteerProjectsService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<VolunteerProjects>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "3") int pageSize
   ){
   	Page<VolunteerProjects> volunteerProjectsPage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<VolunteerProjects> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   	//执行查询
   	volunteerProjectsService.page(volunteerProjectsPage);
   	return R.success(volunteerProjectsPage);
   }
}
