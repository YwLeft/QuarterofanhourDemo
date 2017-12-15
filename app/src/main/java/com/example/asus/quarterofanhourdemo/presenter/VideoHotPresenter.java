package com.example.asus.quarterofanhourdemo.presenter;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bane.GoodsVideoHotModes;
import com.example.asus.quarterofanhourdemo.model.bean.VideoHotBean;
import com.example.asus.quarterofanhourdemo.view.iview.VideoHotView;

import java.util.List;
import java.util.Map;

/**
 * 创建时间  2017/12/13 20:55
 * 创建人    gaozhijie
 * 类描述    推荐——热门presenter层
 */
public class VideoHotPresenter extends BaseDataPresenter<VideoHotView>{

    private GoodsVideoHotModes modes;

    public VideoHotPresenter(VideoHotView iView) {
        super(iView);
        modes = new GoodsVideoHotModes();
    }
    public void getVideoHots (Map<String,String> map){
        modes.getVideoHotModes(new GoodsVideoHotModes.DataVideoHot() {
            @Override
            public void setbutteck(Basebean<List<VideoHotBean>> bean) {
                iView.onGetVideoHotSucceed(bean);
            }

            @Override
            public void setfile(String s) {
                iView.onGetVideoHotFail(s.toString());
            }
        },map);

    }
}
