package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Company;
import org.apache.ibatis.annotations.Mapper;
/**
 * 公司表(Company)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:46
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
 
}
