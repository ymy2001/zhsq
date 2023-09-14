package com.zhsq.utils;

import lombok.Data;

@Data
public class R<T> {
    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private Long all;

    private T data; //数据
    private Object count;//销售总量
    private Object minDiscount;//最低折扣

    public static <T> R<T> success(T object,Long all) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        r.all=all;
        return r;
    }
    public static <T> R<T> success(T object,Long all,Object count,Object minDiscount) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        r.all=all;
        r.count=count;
        r.minDiscount=minDiscount;
        return r;
    }
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }
}
