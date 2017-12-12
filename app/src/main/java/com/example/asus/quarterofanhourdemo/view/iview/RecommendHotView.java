package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;

import java.util.List;

/**
 * 创建时间  2017/12/9 11:49
 * 创建人    gaozhijie
 * 类描述
 */
public interface RecommendHotView extends IView {
    //    获取数据成功
    void onGetRecommendHotSucceed(Basebean<List<RecommendHotBean>> bean);

    //    获取数据失败
    void onGetRecommendHotFail(String e);
}

