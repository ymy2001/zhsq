package com.zhsq.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeePayDTO {
    //用户id
    private Integer userId;
    //业主id
    private String ownerId;
    //缴费单位
    private String companyId;
    //1代表水费 2代表电费 3代表煤气费 4代表物业费 5代表停车费 6代表宽带费
    private Integer feeType;
    //缴费时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date payTime;
    //费用
    private Double fee;
}
