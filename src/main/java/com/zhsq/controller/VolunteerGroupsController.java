package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.VolunteerGroups;
import com.zhsq.service.VolunteerGroupsService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 支援团体(VolunteerGroups)表控制层
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/volunteerGroupss")
public class VolunteerGroupsController {
    /**
     * 服务对象
     */
    @Autowired
    private VolunteerGroupsService volunteerGroupsService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<VolunteerGroups>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "3") int pageSize
   ){
   	Page<VolunteerGroups> volunteerGroupsPage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<VolunteerGroups> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定
   	//执行查询
   	volunteerGroupsService.page(volunteerGroupsPage);
   	return R.success(volunteerGroupsPage);
   }
}
