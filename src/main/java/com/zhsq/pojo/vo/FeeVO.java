package com.zhsq.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeVO {
    //今天产生的费用
    private Double dayFee;
    //一共产生的费用
    private Double allFee;
    //水产生的费用
    private Double water;
    //电产生的费用
    private Double electricity;
    //燃气产生的费用
    private Double gas;
    //物业产生的费用
    private Double property;
    //停车产生的费用
    private Double parking;
    //宽带产生的费用
    private Double broadband;
}
