package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.mapper.ActivityMapper;
import com.zhsq.pojo.Activity;
import com.zhsq.service.ActivityService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 活动表(Activity)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/activityShow")
public class ActivityController {
    /**
     * 服务对象
     */
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMapper activityMapper;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping
   public R<Page<Activity>> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "3") int pageSize){
   	   Page<Activity> activityPage = new Page<>(page, pageSize);
   	   LambdaQueryWrapper<Activity> queryWrapper = new LambdaQueryWrapper<>();
       long total = activityMapper.selectCount(queryWrapper);
       activityPage.setTotal(total);
       log.info("查询总记录数：{}",total);
   	   //执行查询
       Page<Activity> page1 = activityService.page(activityPage);
       return R.success(activityPage,total);
   }
}
