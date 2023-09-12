package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.Data;

/**
 * 轮播图(Slide)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Slide {
     
    private Integer id;
    //图片地址 
    private String slideImage;
    //图片标题 
    private String title;
    //图片链接地址 
    private String slideUrl;
}
