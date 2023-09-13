package com.zhsq.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 通知(Notice)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
     
    private Integer id;
    //标题 
    private String title;
    //简介 
    private String description;
    //创建时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date createTime;
    //详情 
    private String detail;
}
