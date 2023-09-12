package com.zhsq.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeDetailDTO {
    //业主id
    private String ownerId;
    //费用
    private Double fee;
    //0代表未支付,1代表已支付，2代表取消支付
    private Integer payStatus;
    //缴费时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date payTime;
}
