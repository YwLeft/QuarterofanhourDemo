package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间  2017/12/9 11:55
 * 创建人    gaozhijie
 * 类描述   推荐——热门mode层
 */
public class GoodsRecommendHotModes {
    private MRetrofit mRetrofit;

    public GoodsRecommendHotModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getRecommendHotData(final DataRecommendHot dataRecommendHot, Map<String, String> map) {
        mRetrofit.create(ApiService.class)
                .getRecommendHot(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BlockingBaseObserver<Basebean<List<RecommendHotBean>>>() {
                    @Override
                    public void onNext(Basebean<List<RecommendHotBean>> listBasebean) {
                        dataRecommendHot.setbutteck(listBasebean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        dataRecommendHot.setfile(e.toString());
                    }
                });


    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataRecommendHot {
        void setbutteck(Basebean<List<RecommendHotBean>> bean);

        void setfile(String s);
    }
}
