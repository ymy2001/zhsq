package com.zhsq.pojo.dto;

import com.zhsq.pojo.ChatMoments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMomentDTO extends ChatMoments {
    private String pUsername;
    private String pImageUrl;
    private List<String> chatImage;
}
