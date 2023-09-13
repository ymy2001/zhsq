package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户地址管理(UserAddress)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
     
    private Integer id;
    //用户id 
    private Integer userId;
    //名字 
    private String name;
    //手机号 
    private String phoneNumber;
    //地址 
    private String address;
    //0代表不是默认 1代表默认 
    private Integer addressStatus;
}
