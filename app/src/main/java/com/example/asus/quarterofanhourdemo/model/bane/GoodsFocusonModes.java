package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间  2017/12/16 10:04
 * 创建人    gaozhijie
 * 类描述    关注Modes层
 */
public class GoodsFocusonModes {
    private MRetrofit mRetrofit;

    public GoodsFocusonModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getFocusoModes(final DataFocuso dataFocuso, Map<String, String> map) {
        mRetrofit.create(ApiService.class)
                .getFocuson(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    protected void onSuccees(Basebean t) throws Exception {
                        dataFocuso.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        dataFocuso.setfile(e.toString());
                    }
                });
    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataFocuso {
        void setbutteck(Basebean bean);

        void setfile(String s);
    }
}
