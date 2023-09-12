package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Slide;
import org.apache.ibatis.annotations.Mapper;
/**
 * 轮播图(Slide)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:47
 */
@Mapper
public interface SlideMapper extends BaseMapper<Slide> {
 
}
