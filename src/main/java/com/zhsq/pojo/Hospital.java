package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.Data;

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
