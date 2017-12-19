package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.MyFocusonBean;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.presenter.MyFocusonPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.MyFocusonAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.MyFocusonView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 类描述    我的关注
 */
public class MyFocusoActivity extends BaseActivity implements View.OnClickListener, XRecyclerView.LoadingListener, MyFocusonView {
    @BindView(R.id.my_focuson_call_off)
    RadioButton myFocusonCallOff;
    @BindView(R.id.my_hot_focuson)
    TextView myHotFocuson;
    @BindView(R.id.my_focuson_recyclerview)
    XRecyclerView myFocusonRecyclerview;
    public List<String> mlist = new ArrayList<>();
    private MyFocusonPresenter presenter;
    private List<MyFocusonBean> data = new ArrayList<>();

    @Override
    public BaseDataPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_myfocuson;
    }

    @Override
    public void initView() {
        presenter = new MyFocusonPresenter(this);
        String uid = MyApp.getUserInfoSp().getString("userId", "");
        presenter.getData(uid);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_focuson_call_off:
                finish();
                break;
            case R.id.my_hot_focuson:
                break;
            default:
                break;
        }
    }

    @Override
    public void onRefresh() {
        stopxrecyclerview();
    }

    private void stopxrecyclerview() {
        myFocusonRecyclerview.loadMoreComplete();
        myFocusonRecyclerview.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        stopxrecyclerview();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onGetMyFocusonSucceed(Basebean<List<MyFocusonBean>> bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code == 0) {
            data.addAll(bean.getData());
            initData();
        } else if (code == 1) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private void initData() {
        myFocusonCallOff.setOnClickListener(this);
        myHotFocuson.setOnClickListener(this);

        myFocusonRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        MyFocusonAdapter adapter = new MyFocusonAdapter(MyFocusoActivity.this,data);
        myFocusonRecyclerview.setLoadingListener(this);
        myFocusonRecyclerview.setAdapter(adapter);
        myFocusonRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

    @Override
    public void onGetMyFocusonFail(String e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}
