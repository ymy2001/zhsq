package com.zhsq.context;

import java.util.List;

public class BaseContext {

    public static ThreadLocal<String > threadLocal1 = new ThreadLocal<>();
    public static void setCurrentPhone(String  phone) {
        threadLocal1.set(phone);
    }
    public static String getCurrentPhone() {
        return threadLocal1.get();
    }
    public static void removeCurrentPhone() {
        threadLocal1.remove();
    }


    public static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
    public static void setCurrentUser(String user) {
        threadLocal2.set(user);
    }
    public static String getCurrentUser() {
        return threadLocal2.get();
    }
    public static void removeCurrentUser() {
        threadLocal2.remove();
    }



    public static ThreadLocal<Integer> threadLocal3 = new ThreadLocal<>();
    public static void setCurrentId(Integer id) {
        threadLocal3.set(id);
    }
    public static Integer getCurrentId() {
        return threadLocal3.get();
    }
    public static void removeCurrentId(){threadLocal3.remove();}


    public static ThreadLocal <List<String>> threadLocal4 = new ThreadLocal<>();








}
