package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-13 14:45:42
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
 
}
