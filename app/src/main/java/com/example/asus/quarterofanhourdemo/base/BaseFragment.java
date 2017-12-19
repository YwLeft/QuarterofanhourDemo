package com.example.asus.quarterofanhourdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述     Fragmeng的基类
 */
public abstract class BaseFragment<P extends BaseDataPresenter> extends Fragment {
    private static final String TAG = "BaseFragment";
    public P presenter;
    Unbinder unbinder;
    /**
     * Fragment名
     */
    private String mFragmentName;

    public abstract P initPresenter();

    public abstract int getLayoutId();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = initPresenter();
        initView();
        return view;
    }

    public abstract void initView();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentName = getClass().getName();
        Log.d(TAG, getFragmentName() + ", fragment layout id: " + getLayoutId());
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, getFragmentName() + "::onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, getFragmentName() + "::onStart()");
        super.onStart();

    }

    @Override
    public void onResume() {
        Log.d(TAG, getFragmentName() + "::onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, getFragmentName() + "::onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, getFragmentName() + "::onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, getFragmentName() + "::onDestroyView()");
        super.onDestroyView();
        super.onDestroyView();
        if (presenter != null) {
            presenter.deatach();
        }
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, getFragmentName() + "::onDestroy()");

        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, getFragmentName() + "::onDetach()");
        super.onDetach();
    }

    /**
     * 获取Fragment名
     */
    protected String getFragmentName() {
        return mFragmentName;
    }
}