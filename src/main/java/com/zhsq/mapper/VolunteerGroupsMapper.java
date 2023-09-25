package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.VolunteerGroups;
import org.apache.ibatis.annotations.Mapper;
/**
 * 支援团体(VolunteerGroups)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@Mapper
public interface VolunteerGroupsMapper extends BaseMapper<VolunteerGroups> {
 
}
