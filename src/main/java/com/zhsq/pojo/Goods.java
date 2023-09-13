package com.zhsq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Goods)表实体类
 *
 * @author makejava
 * @since 2023-09-13 14:45:42
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    //商品id
    @TableId(type = IdType.AUTO)
    private Integer gid;
    //所属类别编号 
    private Integer typeid;
    //主图 
    private String mainpic;
    //简短标题 
    private String shorttitle;
    //商品名称 
    private String goodsname;
    //简要描述 
    private String descriptions;
    //原价 
    private Double originalprice;
    //折扣率 
    private Double discount;
    //已售数量 
    private Integer soldcount;
    //品牌 
    private String brand;
    //详细描述 
    private String details;
    //是否为“年货精选”  1-是  0-否 
    private Integer isnewyearselection;
    //是否为“品牌精选”  1-是  0-否 
    private Integer isbrandselection;
}
