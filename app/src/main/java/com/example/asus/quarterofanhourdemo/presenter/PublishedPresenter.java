package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsPublishedModes;
import com.example.asus.quarterofanhourdemo.view.iview.PublishedView;

import java.io.File;
import java.util.List;

/**
 * 创建时间  2017/12/4 21:09
 * 创建人    gaozhijie
 * 类描述      段子的persenter层
 */
public class PublishedPresenter extends BaseDataPresenter<PublishedView> {

    String content;
    List<File> list;
    private GoodsPublishedModes modes;
    public PublishedPresenter(PublishedView iView, String content, List<File> list) {
        super(iView);
        this.content = content;
        this.list = list;
        modes = new GoodsPublishedModes(content,list);
    }


    public void getData() {
        modes.getPublishedData(new GoodsPublishedModes.DataPublished() {
            @Override
            public void setbutteck(Basebean bean) {
                iView.onGetPublishedSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetPublishedFail(s);
            }
        });
    }
}
