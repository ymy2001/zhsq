package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.NoticeMapper;
import com.zhsq.pojo.Notice;
import com.zhsq.service.NoticeService;
import org.springframework.stereotype.Service;
 
/**
 * 通知(Notice)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
 
}
