package com.zhsq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhsq.mapper.UserAddressMapper;
import com.zhsq.pojo.UserAddress;
import com.zhsq.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户地址管理(UserAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-09-11 08:49:41
 */
@Service
@Slf4j
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper=getBaseMapper();

    /*
    * 插入用户地址*/
    public void addToAddr(UserAddress userAddress,Integer currentId) {
        Integer status = userAddress.getAddressStatus();
        userAddress.setUserId(currentId);
        Integer userId = userAddress.getUserId();
        log.info("用户id：{}",userId);
        log.info("jwtID：{}",currentId);
        Integer id = userAddress.getId();
        List<UserAddress> userSaveList=new ArrayList<>();
        LambdaQueryWrapper<UserAddress> queryWrapper=new LambdaQueryWrapper<UserAddress>()
                .eq(UserAddress::getUserId,userId);
        log.info("id测试：{}",id);
        if (id!=null){
            extracted(userId, userSaveList, queryWrapper);
            lambdaUpdate().set(UserAddress::getAddressStatus,status)
                    .set(UserAddress::getAddress,userAddress.getAddress())
                    .set(UserAddress::getPhoneNumber,userAddress.getPhoneNumber())
                    .set(UserAddress::getName,userAddress.getName())
                    .eq(UserAddress::getUserId,userId)
                    .eq(UserAddress::getId,id)
                    .update();
            return;
        }
        if (status==1){
            extracted(userId, userSaveList, queryWrapper);
            save(userAddress);

        }
        if (status==0){
            save(userAddress);
        }
    }

    /*根据用户id删除地址*/
    public void deleteAddr(Integer userId, Integer id) {
        UserAddress userAddress=new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setId(id);
        removeById(userAddress);
    }

    private void extracted(Integer userId, List<UserAddress> userSaveList, LambdaQueryWrapper<UserAddress> queryWrapper) {
        List<UserAddress> selectList = userAddressMapper.selectList(queryWrapper);
        userSaveList.addAll(selectList);
        for (UserAddress address : userSaveList) {
            address.setAddressStatus(0);
            lambdaUpdate().set(UserAddress::getAddressStatus, 0)
                    .eq(UserAddress::getUserId, userId)
                    .update();
        }
    }
}
