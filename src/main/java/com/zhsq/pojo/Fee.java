package com.zhsq.pojo;
 
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.Data;

/**
 * 费用(Fee)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户id 
    private Integer userId;
    //业主id 
    private String ownerId;
    //缴费单位 
    private String companyId;
    //1代表水费 2代表电费 3代表煤气费 4代表物业费 5代表停车费 6代表宽带费 
    private Integer feeType;
    //产生费用时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date feeTime;
    //缴费时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date payTime;
    //费用 
    private Double fee;
    //0代表未支付,1代表已支付，2代表取消支付 
    private Integer payStatus;
}
