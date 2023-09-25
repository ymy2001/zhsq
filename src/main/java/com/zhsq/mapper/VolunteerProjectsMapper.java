package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.VolunteerProjects;
import org.apache.ibatis.annotations.Mapper;
/**
 * 志愿项目表(VolunteerProjects)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@Mapper
public interface VolunteerProjectsMapper extends BaseMapper<VolunteerProjects> {
 
}
