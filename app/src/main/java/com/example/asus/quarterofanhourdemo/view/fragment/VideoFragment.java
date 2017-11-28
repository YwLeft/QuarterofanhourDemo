package com.example.asus.quarterofanhourdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.quarterofanhourdemo.R;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      视频页面
 */
public class VideoFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanState) {
        View view = inflater.inflate(R.layout.fragment_video,container,false);
        return view;

    }
}
