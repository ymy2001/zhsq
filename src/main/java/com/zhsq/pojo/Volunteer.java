package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
/**
 * 志愿者表(Volunteer)表实体类
 *
 * @author makejava
 * @since 2023-09-25 09:58:34
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {
    //志愿者id 
    private Integer id;
    //志愿者姓名 
    private String name;
    //评级 
    private Integer star;
    //志愿者头像 
    private String url;
    //服务时间 
    private Integer sTime;
    //距离 
    private Integer distance;
}
