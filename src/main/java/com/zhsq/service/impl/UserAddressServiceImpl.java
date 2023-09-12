package com.zhsq.service.impl;
 
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.FeeMapper;
import com.zhsq.mapper.UserAddressMapper;
import com.zhsq.pojo.UserAddress;
import com.zhsq.service.UserAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户地址管理(UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper=getBaseMapper();

    /*
    * 插入用户地址*/
    public void addToAddr(UserAddress userAddress) {
        Integer status = userAddress.getAddressStatus();
        Integer userId = userAddress.getUserId();
        List<UserAddress> userSaveList=new ArrayList<>();
        LambdaQueryWrapper<UserAddress> queryWrapper=new LambdaQueryWrapper<UserAddress>()
                .eq(UserAddress::getUserId,userId);
        if (status==1){
            List<UserAddress> selectList = userAddressMapper.selectList(queryWrapper);
            userSaveList.addAll(selectList);
            for (UserAddress address : userSaveList) {
                address.setAddressStatus(0);
                lambdaUpdate().set(UserAddress::getAddressStatus,0)
                        .eq(UserAddress::getUserId,userId)
                        .update();
            }
            save(userAddress);

        }
        if (status==0){
            save(userAddress);
        }
    }
}
