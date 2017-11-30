package com.example.asus.quarterofanhourdemo.model.net;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * 创建时间  2017/11/27 15:45
 * 创建人    gaozhijie
 * 类描述    Retrofit
 */

public  class MRetrofit {
    private static MRetrofit INSTANCE;
    private static final String BASE_URL = "https://www.zhaoapi.cn/";
    private Retrofit mRetrofit;
    OkHttpClick okHttpClient;


    private MRetrofit() {

        okHttpClient = MyApp.getOkHttpClick();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public static MRetrofit getinstance(){
        if (INSTANCE==null){
            synchronized (MRetrofit.class){
                if(INSTANCE==null){
                    INSTANCE=new MRetrofit();
                }
            }
        }
        return INSTANCE;
    }

    public <T>T create(Class<T> service){
        return mRetrofit.create(service);
    }
}
