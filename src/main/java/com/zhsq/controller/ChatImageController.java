package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.ChatImage;
import com.zhsq.service.ChatImageService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 用户添加说说的配图(ChatImage)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/chatImages")
public class ChatImageController {
    /**
     * 服务对象
     */
    @Autowired
    private ChatImageService chatImageService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<ChatImage>> getAllByPage(int page, int size){
   	Page<ChatImage> chatImagePage = new Page<>(page, size);
   	LambdaQueryWrapper<ChatImage> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO 查询条件定制
   
   	//执行查询
   	chatImageService.page(chatImagePage);
   	return R.success(chatImagePage);
   }
}
