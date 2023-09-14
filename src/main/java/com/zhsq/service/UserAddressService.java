package com.zhsq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhsq.pojo.UserAddress;

/**
 * 用户地址管理(UserAddress)表服务接口
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
public interface UserAddressService extends IService<UserAddress> {

    /*
    * 插入地址*/
    void addToAddr(UserAddress userAddress,Integer currentId);

    /*
    * 删除地址操作*/
    void deleteAddr(Integer userId, Integer id);
}
