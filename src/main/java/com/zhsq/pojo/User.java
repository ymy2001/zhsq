package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.Data;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
     
    private Long id;
    //用户账号 
    private String user;
    //用户邮箱 
    private String email;
    //用户密码
    private String password;
    //用户手机号 
    private String phoneNumber;
    //用户姓名 
    private String username;
    //用户类型：1代表业主 2代表维修人员 0代表管理人员 
    private Integer userType;
    //用户图片 
    private String userImage;
    //在线状态 
    private Integer isOnline;
}
