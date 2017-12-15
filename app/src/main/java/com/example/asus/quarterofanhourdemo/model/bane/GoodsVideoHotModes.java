package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.VideoHotBean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间  2017/12/13 19:08
 * 创建人    gaozhijie
 * 类描述     视频——热门mode层
 */
public class GoodsVideoHotModes {
    private MRetrofit mRetrofit;

    public GoodsVideoHotModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getVideoHotModes(final DataVideoHot dataVideoHot, Map<String, String> map) {
        mRetrofit.create(ApiService.class)
                .getVideoHotBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<VideoHotBean>>() {
                    @Override
                    protected void onSuccees(Basebean<List<VideoHotBean>> t) throws Exception {
                        dataVideoHot.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        dataVideoHot.setfile(e.toString());
                    }
                });
    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataVideoHot {
        void setbutteck(Basebean<List<VideoHotBean>> bean);

        void setfile(String s);
    }
}
