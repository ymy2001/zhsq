package com.zhsq.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMomentPublicDTO {
    //内容
    private String contents;
    //地点
    private String location;
    //0仅自己可见 1全体可见
    private Integer releaseStatus;
    //图片链接
    private List<String> imgList;
}
