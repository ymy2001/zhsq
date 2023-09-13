package com.zhsq.controller;

import com.zhsq.pojo.Result;
import com.zhsq.pojo.Slide;
import com.zhsq.service.SlideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
