package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.Data;

/**
 * 停车位表(ParkingSpace)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpace {
     
    private Integer id;
    //小区名 
    private String communityName;
    //经度 
    private Double longitude;
    //纬度 
    private Double latitude;
    //总计 
    private Integer total;
}
