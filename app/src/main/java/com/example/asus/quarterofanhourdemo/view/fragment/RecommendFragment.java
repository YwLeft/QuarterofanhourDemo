package com.example.asus.quarterofanhourdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.view.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      推荐页面
 */
public class RecommendFragment extends Fragment {

    @BindView(R.id.recommend_hot)
    RadioButton recommendHot;
    @BindView(R.id.recommend_Focuson)
    RadioButton recommendFocuson;
    @BindView(R.id.recommend_viewpager)
    ViewPager recommendViewpager;
    @BindView(R.id.radiogrouproup)
    RadioGroup radiogrouproup;
    @BindView(R.id.view)
    View ml;
    private List<Fragment> mlist = new ArrayList<>();
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container,false);
        unbinder = ButterKnife.bind(this, view);
        initview();
        return view;
    }

    private void initview() {
        mlist.add(new RecommendHotFragment());
        mlist.add(new RecommendFocusonFragment());

        FragmentManager fm = getFragmentManager();
        ViewPagerAdapter madapter = new ViewPagerAdapter(fm, mlist);
        recommendViewpager.setAdapter(madapter);

        recommendViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int w = ml.getWidth();
                if (positionOffsetPixels != 0) {
                    ml.setX(position * w + positionOffsetPixels / 2);
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        recommendHot.setTextColor(getResources().getColor(R.color.colorbule));
                        recommendFocuson.setTextColor(getResources().getColor(R.color.colorhui));
                        break;
                    case 1:
                        recommendFocuson.setTextColor(getResources().getColor(R.color.colorbule));
                        recommendHot.setTextColor(getResources().getColor(R.color.colorhui));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radiogrouproup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton mbutton = (RadioButton) radioGroup.findViewById(i);
                int is = Integer.parseInt((String) mbutton.getTag());
                recommendViewpager.setCurrentItem(is);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
