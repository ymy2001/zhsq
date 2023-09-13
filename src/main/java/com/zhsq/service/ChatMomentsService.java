package com.zhsq.service;
 
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhsq.pojo.ChatMoments;
import com.zhsq.pojo.dto.ChatMomentPublicDTO;

/**
 * 朋友圈(ChatMoments)表服务接口
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
public interface ChatMomentsService extends IService<ChatMoments> {

    /*
    * 发布说说*/
    void publicChatMoment(Integer userId, ChatMomentPublicDTO chatMomentDTO);

    /*点赞功能实现*/
    void updateLikeCount(Integer chatId, Integer status);
}
