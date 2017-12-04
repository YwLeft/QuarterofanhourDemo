package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;

/**
 * 创建时间  2017/12/4 21:03
 * 创建人    gaozhijie
 * 类描述    定义发布段子接口
 */
public interface PublishedView extends IView{
    //    获取数据成功
    void onGetPublishedSucceed(Basebean bean);
    //    获取数据失败
    void onGetPublishedFail(String e);
}
