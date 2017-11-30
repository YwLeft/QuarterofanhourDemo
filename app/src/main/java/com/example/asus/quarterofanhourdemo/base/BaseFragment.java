package com.example.asus.quarterofanhourdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间  2017/11/23 11:15
 * 创建人    gaozhijie
 * 类描述     Fragmeng的基类
 */
public abstract class BaseFragment<P extends BaseDataPresenter> extends Fragment {

    public P presenter;
    Unbinder unbinder;
    public abstract P initPresenter();

    public abstract int getLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        unbinder = ButterKnife.bind(this, view);
        presenter = initPresenter();
        initView();
        return view;
    }
    public abstract void initView();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.deatach();
        }
        unbinder.unbind();
    }


}