package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.Data;

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
