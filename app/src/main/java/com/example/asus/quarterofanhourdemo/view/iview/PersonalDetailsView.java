package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.PersonalDetailsBean;

import java.util.List;

/**
 * 创建时间  2017/12/15 21:08
 * 创建人    gaozhijie
 * 类描述    个人详情接口
 */
public interface PersonalDetailsView extends IView{
    //    获取数据成功
    void onGetPersonalDetailsSucceed(Basebean<List<PersonalDetailsBean>> bean);
    //    获取数据失败
    void onGetPersonalDetailsFail(String e);
}
