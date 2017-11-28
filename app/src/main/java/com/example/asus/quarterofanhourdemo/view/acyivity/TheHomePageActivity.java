package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;

import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.view.fragment.CrosstalkFragment;
import com.example.asus.quarterofanhourdemo.view.fragment.RecommendFragment;
import com.example.asus.quarterofanhourdemo.view.fragment.VideoFragment;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 11:20
 * 创建人    gaozhijie
 * 类描述      主页面
 */
public class TheHomePageActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.recommend_texttitle)
    TextView recommendTexttitle;
    @BindView(R.id.recommend_imagexie)
    ImageView recommendImagexie;
    @BindView(R.id.radio_rb01)
    RadioButton radioRb01;
    @BindView(R.id.radio_rb02)
    RadioButton radioRb02;
    @BindView(R.id.radio_rb03)
    RadioButton radioRb03;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private Fragment mf1,mf2,mf3;
    private FragmentManager fm;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activivty_thehomepage;
    }

    @Override
    public void initView() {


        radioRb01.setOnClickListener(this);
        radioRb02.setOnClickListener(this);
        radioRb03.setOnClickListener(this);

        mf1 = new RecommendFragment();
        mf2 = new CrosstalkFragment();
        mf3 = new VideoFragment();

        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.fragment,mf1,"mf1");
        ft.commit();

    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.radio_rb01:
                if(!mf1.isAdded()){
                    ft.add(R.id.fragment, mf1,"mf1");
                }
                ft.show(mf1);
                ft.hide(mf2);
                ft.hide(mf3);
                radioRb01.setTextColor(getResources().getColor(R.color.colorbule));
                radioRb03.setTextColor(getResources().getColor(R.color.colorhui));
                radioRb02.setTextColor(getResources().getColor(R.color.colorhui));
                recommendTexttitle.setText("推荐");
                ft.commit();
                break;
            case R.id.radio_rb02:
                if(!mf2.isAdded()){
                    ft.add(R.id.fragment, mf2,"mf2");
                }
                ft.show(mf2);
                ft.hide(mf1);
                ft.hide(mf3);
                radioRb02.setTextColor(getResources().getColor(R.color.colorbule));
                radioRb01.setTextColor(getResources().getColor(R.color.colorhui));
                radioRb03.setTextColor(getResources().getColor(R.color.colorhui));
                recommendTexttitle.setText("段子");
                ft.commit();
                break;
            case R.id.radio_rb03:
                if(!mf3.isAdded()){
                    ft.add(R.id.fragment, mf3,"mf3");
                }
                ft.show(mf3);
                ft.hide(mf2);
                ft.hide(mf1);
                radioRb03.setTextColor(getResources().getColor(R.color.colorbule));
                radioRb01.setTextColor(getResources().getColor(R.color.colorhui));
                radioRb02.setTextColor(getResources().getColor(R.color.colorhui));
                recommendTexttitle.setText("视频");
                ft.commit();
                break;
            default:
                break;
        }
    }
}
