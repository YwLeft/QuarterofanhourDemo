package com.example.asus.quarterofanhourdemo.base;


import android.accounts.NetworkErrorException;
import android.util.Log;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 创建时间  2017/11/27 14:56
 * 创建人    gaozhijie
 * 类描述     Observer基类
 */
public abstract class BaseObserver<T> implements Observer<Basebean<T>> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Basebean<T> basebean) {
        if (basebean.getCode().equals("0")) {
            try {
                onSuccees(basebean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.w("tagaaaaaaa", "onError: "+e.toString());//这里可以打印错误信息
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e);
            } else {
                onFailure(e);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
    }

    /**
     * 返回成功
     *
     * @param t
     * @throws Exception
     */
    protected abstract void onSuccees(Basebean<T> t) throws Exception;

    /**
     * 返回失败
     *
     * @param e
     * @param
     * @throws Exception
     */
    protected abstract void onFailure(Throwable e) throws Exception;


}
