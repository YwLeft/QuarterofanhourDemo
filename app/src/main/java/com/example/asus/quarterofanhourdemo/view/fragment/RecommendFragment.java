package com.example.asus.quarterofanhourdemo.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.view.adapter.RecommendViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      推荐页面
 */
public class RecommendFragment extends BaseFragment {

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


    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        mlist.add(new RecommendHotFragment());
        mlist.add(new RecommendFocusonFragment());

        FragmentManager fm = getFragmentManager();
        RecommendViewPagerAdapter madapter = new RecommendViewPagerAdapter(fm, mlist);
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


}
