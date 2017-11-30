package com.example.asus.quarterofanhourdemo.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.view.adapter.HotAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述      推荐子页面——关注页面
 */
public class RecommendFocusonFragment extends BaseFragment {

    @BindView(R.id.focuson_recyclerview)
    RecyclerView focusonRecyclerview;
    private List<Integer> mlist = new ArrayList<>();
    private List<String> mlist_ry = new ArrayList<>();

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend_focuson;
    }

    @Override
    public void initView() {
        //获取图片
        int resourceId01 = R.drawable.raw_1500258840;
        int resourceId02 = R.drawable.raw_1500258881;
        int resourceId03 = R.drawable.raw_1500258901;
        int resourceId04 = R.drawable.raw_1500259026;
        //添加图片
        mlist.add(resourceId04);
        mlist.add(resourceId03);
        mlist.add(resourceId02);
        mlist.add(resourceId01);
        //模拟数据
        mlist_ry.add("白羊喝牛奶");
        mlist_ry.add("金牛喝果汁");
        mlist_ry.add("双子喝啤酒");
        mlist_ry.add("巨蟹喝五粮液");
        mlist_ry.add("处女喝雪碧");
        mlist_ry.add("天秤喝果粒橙");
        focusonRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotAdapter adapter = new HotAdapter(mlist_ry, getActivity(), mlist);
        focusonRecyclerview.setAdapter(adapter);
    }
}
