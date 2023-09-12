package com.zhsq.pojo;
 
import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动表(Activity)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:01:13
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
     
    private Integer id;
    //活动名 
    private String activityName;
    //开始时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date startTime;
    //结束时间
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date endTime;
    //活动标题 
    private String activityTitle;
    //活动详情 
    private String activityDetail;
    //活动图片 
    private String activityImage;
}
