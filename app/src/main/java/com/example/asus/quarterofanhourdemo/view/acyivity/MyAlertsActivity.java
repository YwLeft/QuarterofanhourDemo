package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.view.fragment.MyDriectFragment;
import com.example.asus.quarterofanhourdemo.view.fragment.MyMessageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/12/1 20:46
 * 创建人    gaozhijie
 * 类描述     我的消息
 */
public class MyAlertsActivity extends BaseActivity {
    @BindView(R.id.my_focuson_call_off)
    RadioButton myFocusonCallOff;
    @BindView(R.id.my_alerts_tablayout)
    TabLayout myAlertsTablayout;
    @BindView(R.id.my_alerts_remove)
    RadioButton myAlertsRemove;

    @BindView(R.id.my_alertsmy)
    TextView myAlertsmy;
    @BindView(R.id.my_alerts_viewPager)
    ViewPager myAlertsViewPager;

    private String[] titles = {"消息", "私信"};
    private List<String> list = new ArrayList<>();
    private List<Fragment> fragmentsList = new ArrayList<>();

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_alerts;
    }

    @Override
    public void initView() {
        myFocusonCallOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        for (String bean : titles) {
            list.add(bean);
        }
        for (String title : list) {
            myAlertsTablayout.addTab(myAlertsTablayout.newTab().setText(title));
        }
        // myAlertsViewPager.setScanScroll(false);
        fragmentsList.add(new MyDriectFragment());
        fragmentsList.add(new MyMessageFragment());
        FragViewAdapter adapter = new FragViewAdapter(getSupportFragmentManager(), fragmentsList);
        myAlertsViewPager.setAdapter(adapter);
        myAlertsTablayout.setupWithViewPager(myAlertsViewPager);
        myAlertsTablayout.setTabsFromPagerAdapter(adapter);

        /**
         * 选择tablayout的监听，一般是用不到的
         */
        myAlertsTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("消息")) {
                    myAlertsRemove.setVisibility(View.VISIBLE);
                    myAlertsmy.setVisibility(View.GONE);
                    myAlertsViewPager.setCurrentItem(0);
                }
                if (tab.getPosition() == 1) {
                    myAlertsRemove.setVisibility(View.GONE);
                    myAlertsmy.setVisibility(View.VISIBLE);
                    myAlertsViewPager.setCurrentItem(1);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }


            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 创建适配器，主要是为了fragmet与标题进行匹配的 继承FragmentPagerAdapter
     */
    class FragViewAdapter extends FragmentPagerAdapter {
        List<Fragment> fragmentList;
        private boolean isPagingEnabled = true;

        public FragViewAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;

        }


        @Override//fragment匹配
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }


        @Override//获取fragment的数量
        public int getCount() {
            return fragmentList.size();
        }

        @Override//对标题进行匹配
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }


        @Override//销毁 不知道这样做行不行
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            fragmentList.get(position).onDestroy();
        }
    }

    @Override
    protected boolean NoTile() {
        return true;
    }
}
