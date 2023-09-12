package com.zhsq.pojo.vo;

import com.zhsq.pojo.dto.ChatMomentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMomentVO {
    private String username;
    private String userImage;
    private List<ChatMomentDTO> chatMomentsList;
}
