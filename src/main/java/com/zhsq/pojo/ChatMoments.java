package com.zhsq.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
