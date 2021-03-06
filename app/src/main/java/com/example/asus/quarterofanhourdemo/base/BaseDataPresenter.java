package com.example.asus.quarterofanhourdemo.base;

import android.content.Context;

import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.view.iview.IView;

/**
 * 类描述    Presenter基类
 */
public class BaseDataPresenter<T extends IView> {

    protected T iView;


    public BaseDataPresenter(T iView) {
        this.iView = iView;
    }

    Context context() {
        if (iView != null && iView.context() != null) {
            return iView.context();
        }
        return MyApp.getContext();
    }
    public void deatach(){
        this.iView = null;
    }

}
