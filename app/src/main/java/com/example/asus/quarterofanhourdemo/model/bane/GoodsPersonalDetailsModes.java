package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.PersonalDetailsBean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间  2017/12/16 8:47
 * 创建人    gaozhijie
 * 类描述     个人详情modes
 */
public class GoodsPersonalDetailsModes {
    private MRetrofit mRetrofit;

    public GoodsPersonalDetailsModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getDataPersonalDetails(final DataPersonalDetails dataPersonalDetails, Map<String, String> map) {
        mRetrofit.create(ApiService.class).getPersonalDetails(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<PersonalDetailsBean>>() {
                    @Override
                    protected void onSuccees(Basebean<List<PersonalDetailsBean>> t) throws Exception {
                        dataPersonalDetails.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        dataPersonalDetails.setfile(e.toString());
                    }
                });
    }

    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataPersonalDetails {
        void setbutteck(Basebean<List<PersonalDetailsBean>> bean);

        void setfile(String s);
    }
}
