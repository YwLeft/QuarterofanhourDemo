package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.MyFocusonBean;

import java.util.List;

/**
 * 创建时间  2017/11/27 16:20
 * 创建人    gaozhijie
 * 类描述     定义我的关注的接口类
 */
public interface MyFocusonView extends IView{
    //    获取数据成功
    void onGetMyFocusonSucceed(Basebean<List<MyFocusonBean>> bean);
    //    获取数据失败
    void onGetMyFocusonFail(String e);
}
