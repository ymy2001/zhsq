package com.zhsq.pojo.vo;

import com.zhsq.pojo.dto.FeeDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * 分页查询封装*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeePageVO {
    private Long total;//分页总数
    private List<FeeDetailDTO> rows;//数据列表
}
