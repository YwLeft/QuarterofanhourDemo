package com.example.asus.quarterofanhourdemo.view.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.presenter.CrosstalkPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.CrosstalkAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.CrosstalkView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      段子页面
 */
public class CrosstalkFragment extends BaseFragment implements CrosstalkView, XRecyclerView.LoadingListener {

    @BindView(R.id.crosstalk_recycler)
    XRecyclerView crosstalkRecycler;
    private CrosstalkPresenter presenter;
    private int page = 1;
    private List<CrosstalkBean> data;


    @Override
    public BaseDataPresenter initPresenter() {
        presenter = new CrosstalkPresenter(this);
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_crosstalk;
    }


    @Override
    public void initView() {
        String pages = String.valueOf(page);
        presenter.getData(pages);
    }

    private void initData() {
        crosstalkRecycler.setLoadingListener(this);
        crosstalkRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        CrosstalkAdapter adapter = new CrosstalkAdapter(data, getActivity());
        crosstalkRecycler.setAdapter(adapter);

    }

    @Override
    public Context context() {
        return getActivity();
    }


    @Override
    public void onGetDataSucceed(Basebean<List<CrosstalkBean>> bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (bean != null && code == 0) {
            data = bean.getData();
            initData();
        } else if (code == 2) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetDataFail(String e) {
        Toast.makeText(getActivity(), "网络错误"+e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        page = 1;
        data.clear();
        initView();
        stoprecycler();

    }

    private void stoprecycler() {
        crosstalkRecycler.refreshComplete();
        crosstalkRecycler.loadMoreComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        initView();
        stoprecycler();
    }
}
