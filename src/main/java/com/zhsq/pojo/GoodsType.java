package com.zhsq.pojo;
 
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.*;
import lombok.Data;

/**
 * 商品类表(GoodsType)表实体类
 *
 * @author makejava
 * @since 2023-09-13 14:45:42
 */
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType {
    //类型id 
    private Integer tid;
    //商品类目 
    private String tname;
}
