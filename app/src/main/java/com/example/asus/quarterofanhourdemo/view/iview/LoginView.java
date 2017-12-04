package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;

/**
 * 创建时间  2017/11/27 16:20
 * 创建人    gaozhijie
 * 类描述     定义登陆的接口类
 */
public interface LoginView extends IView{
    //    获取数据成功
    void onGetLoginSucceed(Basebean<LoginBean> bean);
    //    获取数据失败
    void onGetLoginFail(String e);
}
