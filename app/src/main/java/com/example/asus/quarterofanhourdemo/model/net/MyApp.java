package com.example.asus.quarterofanhourdemo.model.net;

import android.app.Application;
import android.content.Context;

/**
 * 创建时间  2017/11/27 15:05
 * 创建人    gaozhijie
 * 类描述      app
 */
public class MyApp extends Application {

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;


    }


    public static Context getContext() {
        return context;
    }

}
