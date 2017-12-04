package com.example.asus.quarterofanhourdemo.model.net;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 创建时间  2017/11/27 15:05
 * 创建人    gaozhijie
 * 类描述      app
 */
public class MyApp extends Application {

    private static Context context;
    private static SharedPreferences sp;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        // 存放登录的用户信息
        sp = getSharedPreferences("UserInfo",MODE_PRIVATE);


    }

    public static SharedPreferences getUserInfoSp() {
        return sp;
    }

    public static Context getContext() {
        return context;
    }

}
