package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.view.fragment.CrosstalkFragment;
import com.example.asus.quarterofanhourdemo.view.fragment.RecommendFragment;
import com.example.asus.quarterofanhourdemo.view.fragment.VideoFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.BindView;

/**
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
    @BindView(R.id.thehome_image)
    ImageView thehomeImage;
    private Fragment mf1, mf2, mf3;
    private FragmentManager fm;
    private SlidingMenu leftMenu;
    private int age;
    private SharedPreferences sp;
    private ImageView animationImage;
    private TextView name;

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

        initviews();
        radioRb01.setOnClickListener(this);
        radioRb02.setOnClickListener(this);
        radioRb03.setOnClickListener(this);

        thehomeImage.setOnClickListener(this);

        mf1 = new RecommendFragment();
        mf2 = new CrosstalkFragment();
        mf3 = new VideoFragment();

        //读取本地保存的状态及文件
        sp = MyApp.getUserInfoSp();
        if (sp.getBoolean("loginboolen",true)){
            RequestOptions options = new RequestOptions();
            options.placeholder(R.mipmap.ic_launcher_round);
            //设置侧拉图片
            Glide.with(this)
                    .load(sp.getString("userIcon",""))
                    .apply(options)
                    .into(animationImage);

            //设置主页图片
            Glide.with(this)
                    .load(sp.getString("userIcon",""))
                    .apply(options)
                    .into(thehomeImage);
            //设置昵称
            name.setText(sp.getString("userNickname",""));
        }

        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        //根据传不同的值加载不同的页面
        Intent intent = getIntent();
        age = intent.getIntExtra("age",0);
        if (age == 1){
            ft.add(R.id.fragment, mf2, "mf2");
            ft.commit();
            radioRb02.setTextColor(getResources().getColor(R.color.colorbule));
            radioRb02.setChecked(true);
        }else {
            ft.add(R.id.fragment, mf1, "mf1");
            ft.commit();
        }


    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    private void initviews() {
        leftMenu = new SlidingMenu(this);
        View left = View.inflate(this, R.layout.side_left, null);
        RadioButton radioButton = left.findViewById(R.id.side_left_Set);
        LinearLayout linearLayout = left.findViewById(R.id.side_left);
        LinearLayout linearLayoutfocus = left.findViewById(R.id.side_left_focus);
        LinearLayout linearLayoutalerts = left.findViewById(R.id.side_left_alerts);
        animationImage = left.findViewById(R.id.side_left_image);
        name = left.findViewById(R.id.side_left_name);


        leftMenu.setMenu(left);
        leftMenu.setMode(SlidingMenu.LEFT);
        leftMenu.setBehindOffsetRes(R.dimen.slidingmenu_offets);
        leftMenu.setFadeDegree(0.35f);
        leftMenu.setTouchModeAbove(SlidingMenu.LEFT_RIGHT);
        leftMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //各种点击事件
        linearLayout.setOnClickListener(this);
        radioButton.setOnClickListener(this);
        linearLayoutalerts.setOnClickListener(this);
        linearLayoutfocus.setOnClickListener(this);
        recommendImagexie.setOnClickListener(this);


    }

    /**
     * 判断点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.radio_rb01:
                if (!mf1.isAdded()) {
                    ft.add(R.id.fragment, mf1, "mf1");
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
                if (!mf2.isAdded()) {
                    ft.add(R.id.fragment, mf2, "mf2");
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
                if (!mf3.isAdded()) {
                    ft.add(R.id.fragment, mf3, "mf3");
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
            case R.id.thehome_image:
                //点击左侧的图像弹出左侧侧拉菜单
                if (!leftMenu.isMenuShowing()){
                    leftMenu.showMenu();
                }
                break;
            case R.id.side_left_Set:
                Intent intent = new Intent(this,SetUpThesActivity.class);
                startActivity(intent);
                break;
            case R.id.recommend_imagexie:
                Intent intenttwo = new Intent(this,CreationActivity.class);
                startActivity(intenttwo);
                break;
            case R.id.side_left:
                break;
            case R.id.side_left_focus:
                Intent intentfocus = new Intent(this,MyFocusoActivity.class);
                startActivity(intentfocus);
                break;
            case R.id.side_left_alerts:
                Intent intentalerts= new Intent(this,MyAlertsActivity.class);
                startActivity(intentalerts);
                break;

            default:
                break;
        }
    }

}
