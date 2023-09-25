package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Volunteer;
import org.apache.ibatis.annotations.Mapper;
/**
 * 志愿者表(Volunteer)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@Mapper
public interface VolunteerMapper extends BaseMapper<Volunteer> {
 
}
