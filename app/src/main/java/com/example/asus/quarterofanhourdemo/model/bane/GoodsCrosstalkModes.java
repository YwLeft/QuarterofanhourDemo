package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间  2017/11/27 14:56
 * 创建人    gaozhijie
 * 类描述     段子的mode层
 */
public class GoodsCrosstalkModes {
    private MRetrofit mRetrofit;

    public GoodsCrosstalkModes() {
        mRetrofit = MRetrofit.getinstance();
    }


    public void getDataCrosstalk(final Databack databack, String page){

        mRetrofit.create(ApiService.class).getJokes(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<CrosstalkBean>>() {


                    @Override
                    protected void onSuccees(Basebean<List<CrosstalkBean>> t) throws Exception {
                        databack.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        databack.setfile(e.toString());
                    }
                });
    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface Databack{
        void setbutteck(Basebean<List<CrosstalkBean>> bean);
        void setfile(String s);
    }
}
