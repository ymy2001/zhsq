package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公司表(Company)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
     
    private Integer id;
    //公司id 
    private String companyId;
    //公司名 
    private String companyName;
    //公司电话 
    private String companyPhone;
    //公司地址 
    private String companyAddress;
    //缴费类型 1代表水费 2代表电费 3煤气费 4物业费 5停车费 6宽带费 
    private Integer feeType;
}
