package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业主表(Owner)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
     
    private Integer id;
    //业主id 
    private String ownerId;
    //业主性别 
    private Integer ownerGender;
    //业主名 
    private String ownerName;
    //业主地址 
    private String ownerAddress;
    //业主电话 
    private String ownerPhone;
    //业主车辆 
    private String ownerCar;
    //身份证 
    private String identityCard;
}
