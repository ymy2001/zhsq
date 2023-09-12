package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.ChatMomentsMapper;
import com.zhsq.pojo.ChatMoments;
import com.zhsq.service.ChatMomentsService;
import org.springframework.stereotype.Service;
 
/**
 * 朋友圈(ChatMoments)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class ChatMomentsServiceImpl extends ServiceImpl<ChatMomentsMapper, ChatMoments> implements ChatMomentsService {
 
}
