package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 医院表(Hospital)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
     
    private Integer id;
    //医院名 
    private String hospitalName;
    //医院住址 
    private String address;
    //电话 
    private String phoneNumber;
    //经度 
    private Double longitude;
    //纬度 
    private Double latitude;
}
