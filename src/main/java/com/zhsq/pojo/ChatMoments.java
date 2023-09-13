package com.zhsq.pojo;
 
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.Data;

/**
 * 朋友圈(ChatMoments)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMoments {
     
    private Integer id;
    //用户id 
    private Integer userId;
    //内容 
    private String contents;
    //地点 
    private String location;
    //发布时间
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone="Asia/Shanghai")
    private Date releaseTime;
    //喜欢次数 
    private Integer likeCount;
     //评论数
    private Integer replyCount;
    //0仅自己可见 1全体可见 
    private Integer releaseStatus;
}
