package com.example.asus.quarterofanhourdemo.model.net;

/**
 * 创建时间  2017/11/27 15:45
 * 创建人    gaozhijie
 * 类描述    ok的泛型
 */
public interface NetDataCallBack<T> {
    void success(T t);
    void faild(int positon,String str);
}
