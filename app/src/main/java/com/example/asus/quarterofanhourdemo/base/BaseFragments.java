package com.example.asus.quarterofanhourdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 解明明 on 2017/11/29.
 */

public abstract class BaseFragments<p extends BaseDataPresenter> extends Fragment {

    private static final String TAG = "BaseFragment";

    /**
     * presenter
     */
    @Nullable
    protected p presenter;


    public abstract p initPresenter();



    /**
     * Fragment名
     */
    private String mFragmentName;

    @Override
    public void onAttach(Context context) {
        Log.i(TAG,getFragmentName()+"onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentName = getClass().getName();
        Log.d(TAG, getFragmentName() + ", fragment layout id: " + getFragmentLayoutId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, getFragmentName() + "::onCreateView()");

        return inflater.inflate(getFragmentLayoutId(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, getFragmentName() + "::onActivityCreated()");
        if (presenter != null) {
            presenter = initPresenter();
        }
        super.onActivityCreated(savedInstanceState);
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

    /**
     * 获取Fragment Layout Id
     */
    protected abstract int getFragmentLayoutId();

}
