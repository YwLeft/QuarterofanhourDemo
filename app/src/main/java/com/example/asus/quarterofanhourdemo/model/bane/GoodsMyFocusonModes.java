package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.MyFocusonBean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 类描述    我的关注的mode层
 */
public class GoodsMyFocusonModes {
    private MRetrofit mRetrofit;

    public GoodsMyFocusonModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getFocuson(final DataFocuson dataFocuson, String uid) {
        mRetrofit.create(ApiService.class).getMyFocuson(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<MyFocusonBean>>() {
                    @Override
                    protected void onSuccees(Basebean<List<MyFocusonBean>> t) throws Exception {
                        dataFocuson.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        dataFocuson.setfile(e.toString());
                    }
                });
    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataFocuson {
        void setbutteck(Basebean<List<MyFocusonBean>> bean);

        void setfile(String s);
    }
}
