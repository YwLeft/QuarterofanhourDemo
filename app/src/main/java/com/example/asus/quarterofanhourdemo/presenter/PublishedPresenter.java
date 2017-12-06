package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsPublishedModes;
import com.example.asus.quarterofanhourdemo.view.iview.PublishedView;

import java.util.Map;

/**
 * 创建时间  2017/12/4 21:09
 * 创建人    gaozhijie
 * 类描述      段子的persenter层
 */
public class PublishedPresenter extends BaseDataPresenter<PublishedView> {
    private GoodsPublishedModes modes;

    public PublishedPresenter(PublishedView iView) {
        super(iView);
        modes = new GoodsPublishedModes();
    }

    public void getData(Map<String,String> map) {
        modes.getPublishedData(new GoodsPublishedModes.DataPublished() {
            @Override
            public void setbutteck(Basebean bean) {
                iView.onGetPublishedSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetPublishedFail(s);
            }
        },map);
    }
}
