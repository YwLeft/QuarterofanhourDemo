package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间  2017/11/29 9:56
 * 创建人    gaozhijie
 * 类描述    发布段子的mode层
 */
public class GoodsPublishedModes {
    private MRetrofit mRetrofit;

    public GoodsPublishedModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getPublishedData(final GoodsPublishedModes.DataPublished dataPublished, String uid, String content){
        mRetrofit.create(ApiService.class).getPublished(uid,content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    protected void onSuccees(Basebean t) throws Exception {
                        dataPublished.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        dataPublished.setfile(e.toString());
                    }
                });
    }
    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataPublished{
        void setbutteck(Basebean bean);
        void setfile(String s);
    }
}
