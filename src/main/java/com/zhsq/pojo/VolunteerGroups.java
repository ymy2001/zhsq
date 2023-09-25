package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 支援团体(VolunteerGroups)表实体类
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerGroups {
    //团队id 
    private Integer id;
    //支援团队图标 
    private String url;
    //团队名称 
    private String name;
    //团队人数 
    private Integer people;
    //服务时长 
    private Integer serveTime;
    //距离 
    private Integer distance;
}
