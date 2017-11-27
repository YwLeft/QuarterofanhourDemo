package com.example.asus.quarterofanhourdemo.base;


/**
 * 创建时间  2017/11/23 11:15
 * 创建人    gaozhijie
 * 类描述
 */
public class BasePresenter<V> {
    private V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void deatach(){
        this.mView = null;
    }
}
