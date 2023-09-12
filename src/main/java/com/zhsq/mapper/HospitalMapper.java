package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Hospital;
import org.apache.ibatis.annotations.Mapper;
/**
 * 医院表(Hospital)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:47
 */
@Mapper
public interface HospitalMapper extends BaseMapper<Hospital> {
 
}
