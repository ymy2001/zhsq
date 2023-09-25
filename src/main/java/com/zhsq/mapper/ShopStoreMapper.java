package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.ShopStore;
import org.apache.ibatis.annotations.Mapper;
/**
 * 社区商店(ShopStore)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-25 14:29:56
 */
@Mapper
public interface ShopStoreMapper extends BaseMapper<ShopStore> {
 
}
