package com.zhsq.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpVO {
    //用户手机号
    private String phoneNumber;
    //用户姓名
    private String username;
}
