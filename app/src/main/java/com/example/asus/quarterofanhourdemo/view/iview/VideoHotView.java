package com.example.asus.quarterofanhourdemo.view.iview;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.VideoHotBean;

import java.util.List;

/**
 * 创建时间  2017/12/13 16:43
 * 创建人    gaozhijie
 * 类描述    视频的关注页面接口
 */
public interface VideoHotView extends IView {
    //    获取数据成功
    void onGetVideoHotSucceed(Basebean<List<VideoHotBean>> bean);

    //    获取数据失败
    void onGetVideoHotFail(String e);
}
