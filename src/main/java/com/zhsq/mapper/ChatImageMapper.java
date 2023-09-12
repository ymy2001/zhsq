package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.ChatImage;
import org.apache.ibatis.annotations.Mapper;
/**
 * 用户添加说说的配图(ChatImage)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:46
 */
@Mapper
public interface ChatImageMapper extends BaseMapper<ChatImage> {
 
}
