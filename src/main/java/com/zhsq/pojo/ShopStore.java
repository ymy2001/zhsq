package com.zhsq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 社区商店(ShopStore)表实体类
 *
 * @author makejava
 * @since 2023-09-25 14:29:52
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopStore {
    //商店id 
    private Integer id;
    //商店名称 
    private String name;
    //商店位置 
    private String location;
    //评价等级 
    private Integer star;
    //销量 
    private Integer count;
    //距离 
    private Integer distance;
    //起送价格 
    private Double begin;
    //配送价格 
    private Double price;
    //商店链接 
    private String url;
}
