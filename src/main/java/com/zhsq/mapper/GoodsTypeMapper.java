package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
/**
 * 商品类表(GoodsType)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-13 14:45:42
 */
@Mapper
public interface GoodsTypeMapper extends BaseMapper<GoodsType> {
 
}
