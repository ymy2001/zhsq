package com.zhsq.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeOwnerVO {
    //业主名
    private String ownerName;
    //业主地址
    private String ownerAddress;
}
