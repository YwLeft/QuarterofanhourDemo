package com.example.asus.quarterofanhourdemo.view.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.view.adapter.MyDriectAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * 创建时间  2017/12/2 9:14
 * 创建人    gaozhijie
 * 类描述     消息通知子页面消息页面
 */
public class MyDriectFragment extends BaseFragment implements XRecyclerView.LoadingListener {


    @BindView(R.id.mydriect_xrecyclereview)
    XRecyclerView mydriectXrecyclereview;


    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_driect;
    }

    @Override
    public void initView() {
        mydriectXrecyclereview.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyDriectAdapter adapter = new MyDriectAdapter(getActivity());
        mydriectXrecyclereview.setLoadingListener(this);
        mydriectXrecyclereview.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        stopxrecyclerview();
    }

    private void stopxrecyclerview() {
        mydriectXrecyclereview.loadMoreComplete();
        mydriectXrecyclereview.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        stopxrecyclerview();
    }



}
