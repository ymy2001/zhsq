package com.zhsq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.zhsq.mapper.ChatMomentsMapper;
import com.zhsq.pojo.ChatImage;
import com.zhsq.pojo.ChatMoments;
import com.zhsq.pojo.dto.ChatMomentPublicDTO;
import com.zhsq.service.ChatMomentsService;
import com.zhsq.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 朋友圈(ChatMoments)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
@Slf4j
public class ChatMomentsServiceImpl extends ServiceImpl<ChatMomentsMapper, ChatMoments> implements ChatMomentsService {

    /*
    * 发布说说*/
    public void publicChatMoment(Integer userId, ChatMomentPublicDTO chatMomentPublicDTO) {
        ChatMoments chatMoments=new ChatMoments();
        BeanUtils.copyProperties(chatMomentPublicDTO,chatMoments);
        chatMoments.setUserId(userId);
        chatMoments.setLikeCount(0);
        chatMoments.setReplyCount(0);
        chatMoments.setReleaseTime(DateUtils.toDate(LocalDateTime.now()));
        save(chatMoments);
        int returnId=chatMoments.getId();
        log.info("发布信息id：{}",returnId);
        //获取图片信息
        List<String> imgList = chatMomentPublicDTO.getImgList();
        List<ChatImage> chatImageList=new ArrayList<>();
        for (String image : imgList) {
            ChatImage chatImage=new ChatImage();
            chatImage.setChatId(returnId);
            chatImage.setImageUrl(image);
            chatImageList.add(chatImage);
        }
        Db.saveBatch(chatImageList);
    }

    /*
    * 用户点赞功能实现*/
    public void updateLikeCount(Integer chatId, Integer status) {
        ChatMoments chat = lambdaQuery().eq(ChatMoments::getId, chatId).one();
        //当前点赞数
        Integer likeCount = chat.getLikeCount();
        likeCount+=1;
        lambdaUpdate().set(ChatMoments::getLikeCount,likeCount)
                .eq(ChatMoments::getId,chatId)
                .update();
    }
}
