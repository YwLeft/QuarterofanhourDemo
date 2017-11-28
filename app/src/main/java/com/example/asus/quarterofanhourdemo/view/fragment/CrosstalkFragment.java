package com.example.asus.quarterofanhourdemo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.presenter.CrosstalkPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.CrosstalkAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.CrosstalkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      段子页面
 */
public class CrosstalkFragment extends Fragment implements CrosstalkView{
    @BindView(R.id.crosstalk_recycler)
    RecyclerView crosstalkRecycler;
    Unbinder unbinder;
    private CrosstalkPresenter presenter;
    private List<CrosstalkBean.DataBean.UserBean> mlist_user = new ArrayList<>();
    private List<CrosstalkBean.DataBean> mlist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanState) {
        View view = inflater.inflate(R.layout.fragment_crosstalk,container,false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        presenter = new CrosstalkPresenter(this);
        presenter.getData();
    }

    private void initview() {
        crosstalkRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        CrosstalkAdapter adapter = new CrosstalkAdapter(mlist_user,getActivity());
        crosstalkRecycler.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
            for (CrosstalkBean.DataBean bean1:mlist){
                mlist_user.add(bean1.getUser());
            }
            initview();
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
