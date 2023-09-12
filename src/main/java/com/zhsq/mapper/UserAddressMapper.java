package com.zhsq.mapper;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhsq.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
/**
 * 用户地址管理(UserAddress)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-11 08:45:47
 */
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress> {
 
}
