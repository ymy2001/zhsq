package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhsq.pojo.ChatMoments;
import com.zhsq.service.ChatMomentsService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
 
/**
 * 朋友圈(ChatMoments)表控制层
 *
 * @author makejava
 * @since 2023-09-09 10:13:33
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/chatMomentss")
public class ChatMomentsController {
    /**
     * 服务对象
     */
    @Autowired
    private ChatMomentsService chatMomentsService;
 
     /**
   * 分页查询
   * @param page 查询页数
   * @param size 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public R<Page<ChatMoments>> getAllByPage(int page, int size){
   	Page<ChatMoments> chatMomentsPage = new Page<>(page, size);
   	LambdaQueryWrapper<ChatMoments> queryWrapper = new LambdaQueryWrapper<>();
   	//TODO 查询条件定制
   
   	//执行查询
   	chatMomentsService.page(chatMomentsPage);
   	return R.success(chatMomentsPage);
   }
}
