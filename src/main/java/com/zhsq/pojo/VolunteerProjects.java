package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 志愿项目表(VolunteerProjects)表实体类
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerProjects {
    //项目id 
    private Integer id;
    //志愿项目名称 
    private String name;
    //发布团队 
    private String pName;
    //发布时间 
    private Date pTime;
    //结束时间 
    private Date eTime;
    //计划人数 
    private Integer plan;
    //已招人数 
    private Integer isPlan;
    //服务图标 
    private String url;
    //距离 
    private Integer distance;
}
