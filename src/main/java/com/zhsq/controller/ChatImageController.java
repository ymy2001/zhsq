package com.zhsq.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.ChatImage;
import com.zhsq.service.ChatImageService;
import com.zhsq.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
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
   	//执行查询
   	chatImageService.page(chatImagePage);
   	return R.success(chatImagePage);
   }
}
