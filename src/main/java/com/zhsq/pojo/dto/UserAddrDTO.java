package com.zhsq.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddrDTO {
    //当前地址id
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

