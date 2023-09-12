package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.Result;
import com.zhsq.pojo.Slide;
import com.zhsq.service.SlideService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 轮播图(Slide)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/slideShow")
public class SlideController {
    /**
     * 服务对象
     */
    @Autowired
    private SlideService slideService;
    /*
    * 轮播图查询显示*/
    @GetMapping
    public Result<List<Slide>> slideResult(){
        log.info("轮播图查询");
        List<Slide> list = slideService.list();
        return Result.success("success",list);
    }
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<Slide>> getAllByPage(int page, int pageSize){
   	Page<Slide> slidePage = new Page<>(page, pageSize);
   	LambdaQueryWrapper<Slide> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO查询条件定制

       // 执行查询
   	slideService.page(slidePage);
   	return R.success(slidePage);
   }
}
