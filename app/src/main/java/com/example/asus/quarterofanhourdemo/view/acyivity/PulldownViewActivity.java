package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.PersonalDetailsBean;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.presenter.FocusonPresenter;
import com.example.asus.quarterofanhourdemo.presenter.PersonalDetailsPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.PersonalDetailsAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.AnimationImage;
import com.example.asus.quarterofanhourdemo.view.iview.FocusonView;
import com.example.asus.quarterofanhourdemo.view.iview.PersonalDetailsView;
import com.example.asus.quarterofanhourdemo.view.iview.PullScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 创建时间  2017/12/1 11:26
 * 创建人    gaozhijie
 * 类描述    个人详情
 */
public class PulldownViewActivity extends BaseActivity implements PullScrollView.OnTurnListener, View.OnClickListener, PersonalDetailsView, FocusonView {
    @BindView(R.id.background_img)
    ImageView mHeadImg;
    @BindView(R.id.Personal_details_return)
    ImageView PersonalDetailsReturn;
    @BindView(R.id.Personal_details_zan)
    TextView PersonalDetailsZan;
    @BindView(R.id.Personal_details_guanzhu)
    TextView PersonalDetailsGuanzhu;
    @BindView(R.id.Personal_details_tou)
    AnimationImage PersonalDetailsTou;
    @BindView(R.id.Personal_details_count)
    TextView PersonalDetailsCount;
    @BindView(R.id.Personal_details_recycler)
    RecyclerView PersonalDetailsRecycler;
    @BindView(R.id.scroll_view)
    PullScrollView mScrollView;
    private PersonalDetailsPresenter presenter;
    private int page = 1;
    private List<PersonalDetailsBean> data = new ArrayList<>();
    private PersonalDetailsAdapter adapter;
    private String uid;
    private Intent intent;

    @Override
    public BaseDataPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_pull_down;
    }

    @Override
    public void initView() {
        mScrollView.setHeader(mHeadImg);
        mScrollView.setOnTurnListener(this);
        intent = getIntent();
        uid = intent.getStringExtra("uid");
        String tou = intent.getStringExtra("tou");
        String nickname = intent.getStringExtra("nickname");
        //设置头像
        Glide.with(this).load(tou).into(PersonalDetailsTou);
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("page", String.valueOf(page));
        presenter = new PersonalDetailsPresenter(this);
        presenter.getData(map);
        PersonalDetailsReturn.setOnClickListener(this);
        PersonalDetailsGuanzhu.setOnClickListener(this);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onTurn() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Personal_details_return:
                finish();
                break;
            case R.id.Personal_details_guanzhu:
                Map<String, String> map = new HashMap<>();
                map.put("uid", MyApp.getUserInfoSp().getString("userId", ""));
                map.put("followId", uid);
                FocusonPresenter focusonPresenter = new FocusonPresenter(this);
                focusonPresenter.getData(map);
                break;
            default:
                break;
        }
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onGetPersonalDetailsSucceed(Basebean<List<PersonalDetailsBean>> bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code == 0) {
            data.addAll(bean.getData());
            int size = bean.getData().size();
            PersonalDetailsCount.setText("作品(" + size + ")");
            initData();
        } else if (code == 1) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private void initData() {
        PersonalDetailsRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonalDetailsAdapter(data, this);
        PersonalDetailsRecycler.setAdapter(adapter);
    }

    @Override
    public void onGetPersonalDetailsFail(String e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetFocusonSucceed(Basebean bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code == 0) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            PersonalDetailsGuanzhu.setBackgroundResource(R.drawable.shapeguan);
            // bean.setGuan(true);
        } else if (code == 1) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            PersonalDetailsGuanzhu.setBackgroundResource(R.drawable.shapeguan);
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetFocusonFail(String e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
