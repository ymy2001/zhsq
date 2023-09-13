package com.zhsq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @TableId(type = IdType.AUTO)
    private Integer tid;
    //商品类目 
    private String tname;
}
