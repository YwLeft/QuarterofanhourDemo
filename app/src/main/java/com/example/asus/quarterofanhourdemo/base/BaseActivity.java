package com.example.asus.quarterofanhourdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/23 11:15
 * 创建人    gaozhijie
 * 类描述     Activity的基类
 */
public abstract class BaseActivity<P extends BaseDataPresenter> extends AppCompatActivity {

    public P presenter;

    public abstract P initPresenter();

    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = initPresenter();
        initView();
    }

    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatach();
        }

    }

}