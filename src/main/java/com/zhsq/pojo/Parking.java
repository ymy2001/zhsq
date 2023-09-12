package com.zhsq.pojo;
 
import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.Data;

/**
 * 停车位表(Parking)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parking {
     
    private Integer id;
    //用户id 
    private Integer userId;
    //业主id 
    private Integer ownerId;
    //小区停车名 
    private String communityName;
    //0代表空闲车位 1代表车位已占 2代表私有车位但是出租车位 3代表私有车位 
    private Integer parkingStatus;
    //开始时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date startTime;
    //结束时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date endTime;
    //地址 
    private String address;
}
