package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsRecommendHotModes;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;
import com.example.asus.quarterofanhourdemo.view.iview.RecommendHotView;

import java.util.List;
import java.util.Map;

/**
 * 创建时间  2017/12/11 10:33
 * 创建人    gaozhijie
 * 类描述   推荐——热门presenter层
 */
public class RecommendHotPresenter extends BaseDataPresenter<RecommendHotView>{

    private GoodsRecommendHotModes modes;

    public RecommendHotPresenter(RecommendHotView iView) {
        super(iView);
        modes = new GoodsRecommendHotModes();
    }
    public void getData(Map<String,String> map) {
        modes.getRecommendHotData(new GoodsRecommendHotModes.DataRecommendHot() {
            @Override
            public void setbutteck(Basebean<List<RecommendHotBean>> bean) {
                iView.onGetRecommendHotSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetRecommendHotFail(s.toString());
            }
        },map);
    }
}
