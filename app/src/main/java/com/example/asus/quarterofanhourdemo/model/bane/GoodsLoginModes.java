package com.example.asus.quarterofanhourdemo.model.bane;

import com.example.asus.quarterofanhourdemo.base.BaseObserver;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;
import com.example.asus.quarterofanhourdemo.model.net.ApiService;
import com.example.asus.quarterofanhourdemo.model.net.MRetrofit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 类描述    登陆的mode层
 */
public class GoodsLoginModes {
    private MRetrofit mRetrofit;

    public GoodsLoginModes() {
        mRetrofit = MRetrofit.getinstance();
    }

    public void getLoginData(final DataLigin dataLigin, String mobile,String password){
        mRetrofit.create(ApiService.class).getLogin(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    protected void onSuccees(Basebean<LoginBean> t) throws Exception {
                        dataLigin.setbutteck(t);
                    }

                    @Override
                    protected void onFailure(Throwable e) throws Exception {
                        dataLigin.setfile(e.toString());
                    }
                });
    }
    /**
     * 定义两个接口，一个成功，一个失败
     */
    public interface DataLigin{
        void setbutteck(Basebean<LoginBean> bean);
        void setfile(String s);
    }
}
