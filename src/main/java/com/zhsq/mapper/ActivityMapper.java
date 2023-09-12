package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
/**
 * 活动表(Activity)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:42
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
 
}
