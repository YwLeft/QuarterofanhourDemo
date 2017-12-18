package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;

/**
 * 创建时间  2017/12/16 10:03
 * 创建人    gaozhijie
 * 类描述    关注接口
 */
public interface FocusonView extends IView{
    //    获取数据成功
    void onGetFocusonSucceed(Basebean bean);
    //    获取数据失败
    void onGetFocusonFail(String e);
}
