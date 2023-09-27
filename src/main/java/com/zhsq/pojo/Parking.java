package com.zhsq.pojo;
 
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
/**
 * 停车位表(Parking)表实体类
 *
 * @author makejava
 * @since 2023-09-26 14:56:02
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parking {
     
    private Integer id;
    //用户id 
    private Integer userId;
    //业主id 
    private String ownerId;
    //小区停车名 
    private String communityName;
    //0代表业主车位 1代表车位出租 2代表空闲车位 
    private Integer parkingStatus;
    //开始时间 
    private Date startTime;
    //结束时间 
    private Date endTime;
    //地址 
    private String address;
    //车位照片 
    private String url;
}
