package com.example.asus.quarterofanhourdemo.view.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;
import com.example.asus.quarterofanhourdemo.presenter.RecommendHotPresenter;
import com.example.asus.quarterofanhourdemo.view.adapter.HotAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.RecommendHotView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述    推荐子页面——热门页面
 */
public class RecommendHotFragment extends BaseFragment implements XRecyclerView.LoadingListener, RecommendHotView {

    @BindView(R.id.hot_recyclerview)
    XRecyclerView hotRecyclerview;
    private List<Integer> mlist = new ArrayList<>();
    private RecommendHotPresenter presenter;
    private List<RecommendHotBean> data = new ArrayList<>();
    private Map<String, String> map;
    int page = 1;


    @Override
    public BaseDataPresenter initPresenter() {
        presenter = new RecommendHotPresenter(this);
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend_hot;
    }

    private void initData() {
        hotRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotAdapter adapter = new HotAdapter(data, getActivity(), mlist);
        hotRecyclerview.setLoadingListener(this);
        hotRecyclerview.setAdapter(adapter);

       /*adapter.setSetitemonclick(new HotAdapter.setitemonclick() {
            @Override
            public void setonitemhol(View view) {
                Intent intent = new Intent(getContext(), Nextvideoview.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void initView() {
        map = new HashMap<>();
        map.put("type","1");
        String pages = String.valueOf(page);
        map.put("page",pages);
        presenter.getData(map);

        //获取图片
        int resourceId01 = R.drawable.raw_1500258840;
        int resourceId02 = R.drawable.raw_1500258881;
        int resourceId03 = R.drawable.raw_1500258901;
        int resourceId04 = R.drawable.raw_1500259026;
        //添加图片
        mlist.add(resourceId01);
        mlist.add(resourceId02);
        mlist.add(resourceId03);
        mlist.add(resourceId04);

    }

    @Override
    public void onRefresh() {
        page=1;
        data.clear();
        initView();
        stoprecycler();
    }
    private void stoprecycler() {
        hotRecyclerview.refreshComplete();
        hotRecyclerview.loadMoreComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        initView();
        stoprecycler();
    }


    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onGetRecommendHotSucceed(Basebean<List<RecommendHotBean>> bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code == 0){
            data.addAll(bean.getData());
            initData();
        }else if (code == 1){
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onGetRecommendHotFail(String e) {
        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
    }
}
