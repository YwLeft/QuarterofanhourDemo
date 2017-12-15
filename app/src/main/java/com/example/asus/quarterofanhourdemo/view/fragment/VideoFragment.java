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
import com.example.asus.quarterofanhourdemo.view.adapter.VideoViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      视频页面
 */
public class VideoFragment extends BaseFragment {
    @BindView(R.id.video_hot)
    RadioButton videoHot;
    @BindView(R.id.video_nearby)
    RadioButton videoNearby;
    @BindView(R.id.video_rg)
    RadioGroup videoRg;
    @BindView(R.id.video_view)
    View videoView;
    @BindView(R.id.video_viewpager)
    ViewPager videoViewpager;

    private List<Fragment> mlist = new ArrayList<>();


    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initView() {
        mlist.add(new VideoHotFragment());
        mlist.add(new VideoNearbyFragment());

        FragmentManager fm = getFragmentManager();
        VideoViewPagerAdapter madapter = new VideoViewPagerAdapter(fm, mlist);
        videoViewpager.setAdapter(madapter);

        videoViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int w = videoView.getWidth();
                if (positionOffsetPixels != 0) {
                    videoView.setX(position * w + positionOffsetPixels / 2);
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        videoHot.setTextColor(getResources().getColor(R.color.colorbule));
                        videoNearby.setTextColor(getResources().getColor(R.color.colorhui));
                        break;
                    case 1:
                        videoNearby.setTextColor(getResources().getColor(R.color.colorbule));
                        videoHot.setTextColor(getResources().getColor(R.color.colorhui));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        videoRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton mbutton = radioGroup.findViewById(i);
                int is = Integer.parseInt((String) mbutton.getTag());
                videoViewpager.setCurrentItem(is);
            }
        });

    }

}
