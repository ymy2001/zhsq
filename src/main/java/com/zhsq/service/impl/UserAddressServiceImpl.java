package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.UserAddressMapper;
import com.zhsq.pojo.UserAddress;
import com.zhsq.service.UserAddressService;
import org.springframework.stereotype.Service;
 
/**
 * 用户地址管理(UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
 
}
