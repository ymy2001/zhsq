package com.zhsq.service;
 
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhsq.pojo.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户地址管理(UserAddress)表服务接口
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
public interface UserAddressService extends IService<UserAddress> {

    /*
    * 插入地址*/
    void addToAddr(UserAddress userAddress);
}
