package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户添加说说的配图(ChatImage)表实体类
 *
 * @author makejava
 * @since 2023-09-09 10:08:32
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatImage {
     
    private Integer id;
    //说说id 
    private Integer chatId;
    //图片地址 
    private String imageUrl;
}
