package com.zhsq.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
    private Long id;
    //用户账号
    private String user;
    //用户邮箱
    private String email;
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
