package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Volunteer;
import com.zhsq.service.VolunteerService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 志愿者表(Volunteer)表控制层
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/volunteers")
public class VolunteerController {
    /**
     * 服务对象
     */
    @Autowired
    private VolunteerService volunteerService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Volunteer>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "5") int pageSize
   ){
   	Page<Volunteer> volunteerPage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<Volunteer> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制
   	//执行查询
   	volunteerService.page(volunteerPage);
   	return R.success(volunteerPage);
   }
}
