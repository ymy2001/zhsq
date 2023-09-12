package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.ChatMoments;
import org.apache.ibatis.annotations.Mapper;
/**
 * 朋友圈(ChatMoments)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:46
 */
@Mapper
public interface ChatMomentsMapper extends BaseMapper<ChatMoments> {
 
}
