package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;

/**
 * 创建时间  2017/11/27 16:20
 * 创建人    gaozhijie
 * 类描述     定义关注的接口类
 */
public interface FocusonView extends IView{
    //    获取数据成功
    void onGetFocusonSucceed(Basebean bean);
    //    获取数据失败
    void onGetFocusonFail(String e);
}
