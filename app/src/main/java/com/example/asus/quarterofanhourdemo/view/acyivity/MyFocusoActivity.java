package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.MyFocusonAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/12/1 19:43
 * 创建人    gaozhijie
 * 类描述    我的关注
 */
public class MyFocusoActivity extends BaseActivity implements View.OnClickListener, XRecyclerView.LoadingListener {
    @BindView(R.id.my_focuson_call_off)
    RadioButton myFocusonCallOff;
    @BindView(R.id.my_hot_focuson)
    TextView myHotFocuson;
    @BindView(R.id.my_focuson_recyclerview)
    XRecyclerView myFocusonRecyclerview;
    public List<String> mlist = new ArrayList<>();

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_myfocuson;
    }

    @Override
    public void initView() {
        myFocusonCallOff.setOnClickListener(this);
        myHotFocuson.setOnClickListener(this);

        myFocusonRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        MyFocusonAdapter adapter = new MyFocusonAdapter(MyFocusoActivity.this);
        myFocusonRecyclerview.setLoadingListener(this);
        myFocusonRecyclerview.setAdapter(adapter);
        myFocusonRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

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
}
