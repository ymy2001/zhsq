package com.zhsq.controller;
 
 
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.zhsq.context.BaseContext;
import com.zhsq.mapper.ChatMomentsMapper;
import com.zhsq.pojo.*;
import com.zhsq.pojo.dto.ChatMomentDTO;
import com.zhsq.pojo.vo.ChatMomentVO;
import com.zhsq.service.ChatMomentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.zhsq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private ChatMomentsMapper chatMomentsMapper;
    /*
    * 发布说说*/
    @PostMapping("/public")
    public Result publicTalk(@RequestBody ChatMomentDTO chatMomentDTO){
        return null;
    }
     /**
   * 分页查询
   * @param page 查询页数
   * @param pageSize 一页显示条数
   * @return ·
   */
   @GetMapping("/page")
   public Result<ChatMomentVO> getAllByPage(
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "5") int pageSize
   ){
       Integer currentId = BaseContext.getCurrentId();
       log.info("聊天页面查询,当前用户：{}",currentId);
       User user = Db.lambdaQuery(User.class).eq(User::getId, currentId).one();
       ChatMomentVO chatMomentVO=new ChatMomentVO();
       BeanUtils.copyProperties(user,chatMomentVO);
       Page<ChatMoments> chatMomentsPage = new Page<>(page, pageSize);
   	   LambdaQueryWrapper<ChatMoments> queryWrapper = new LambdaQueryWrapper<>();
   	   //执行查询
       Page<ChatMoments> chatMomentsPage1 = new Page<>(page, pageSize);
       List<ChatMoments> records = chatMomentsMapper.selectPage(chatMomentsPage1, queryWrapper).getRecords();
       log.info("分页详情{}",records);
       List<ChatMomentDTO> chatList=new ArrayList<>();
       log.info("当前列表长度：{}",records.size());
       for (ChatMoments record : records) {
           ChatMomentDTO chatMomentDTO = new ChatMomentDTO();
           BeanUtils.copyProperties(record,chatMomentDTO);
           Integer userId = record.getUserId();
           User puser = Db.lambdaQuery(User.class).eq(User::getId, userId).one();
           Integer chatId = record.getId();
           log.info("当前发表用户id：{},聊天id:{}", userId, chatId);
           chatMomentDTO.setPUsername(puser.getUsername());
           chatMomentDTO.setPImageUrl(puser.getUserImage());
           //log.info("图片列表：{}",imgList);
           chatList.add(chatMomentDTO);
           List<ChatImage> imgList = Db.lambdaQuery(ChatImage.class).eq(ChatImage::getChatId, chatId)
                   .list();
           List<String> image = new ArrayList<>();
           for (ChatImage chatImage : imgList) {
               String imageUrl = chatImage.getImageUrl();
               image.add(imageUrl);
           }
           chatMomentDTO.setChatImage(image);

       }
       chatMomentVO.setChatMomentsList(chatList);
       log.info("封装用户信息：{}",chatMomentVO);
       BaseContext.removeCurrentId();
       return Result.success(chatMomentVO);
   }
}
