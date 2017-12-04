package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;

import java.util.List;

/**
 * 创建时间  2017/11/27 16:20
 * 创建人    gaozhijie
 * 类描述     定义段子的接口类
 */
public interface CrosstalkView extends IView{
    //    获取数据成功
    void onGetDataSucceed(Basebean<List<CrosstalkBean>> bean);
    //    获取数据失败
    void onGetDataFail(String e);
}
