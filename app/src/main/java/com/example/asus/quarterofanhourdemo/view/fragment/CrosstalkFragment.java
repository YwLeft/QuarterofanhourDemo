package com.example.asus.quarterofanhourdemo.view.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.presenter.CrosstalkPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.CrosstalkAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.CrosstalkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      段子页面
 */
public class CrosstalkFragment extends BaseFragment implements CrosstalkView{

    @BindView(R.id.crosstalk_recycler)
    RecyclerView crosstalkRecycler;
    private CrosstalkPresenter presenter;
    private List<CrosstalkBean.DataBean> mlist = new ArrayList<>();
    private int page = 1;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_crosstalk;
    }


    @Override
    public void initView() {
        presenter = new CrosstalkPresenter(this);
        String pages = String.valueOf(page);
        presenter.getData(pages);
    }

    private void initData() {
        crosstalkRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        CrosstalkAdapter adapter = new CrosstalkAdapter(mlist,getActivity());
        crosstalkRecycler.setAdapter(adapter);
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onGetDataSucceed(CrosstalkBean bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (bean != null&&code==0){
            mlist.addAll(bean.getData());
            initData();
        }else if (code==2){
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetDataFail(String e) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }
}
