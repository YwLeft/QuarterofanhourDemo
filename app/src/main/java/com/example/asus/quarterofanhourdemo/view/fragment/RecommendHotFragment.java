package com.example.asus.quarterofanhourdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.view.adapter.HotAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间  2017/11/23 18:45
 * 创建人    gaozhijie
 * 类描述    推荐子页面——热门页面
 */
public class RecommendHotFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.hot_recyclerview)
    RecyclerView hotRecyclerview;
    private List<Integer> mlist = new ArrayList<>();
    private List<String> mlist_ry = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanState) {
        View view = inflater.inflate(R.layout.fragment_recommend_hot, null);
        unbinder = ButterKnife.bind(this, view);
        initview();
        return view;
    }

    private void initview() {
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
        //模拟数据
        mlist_ry.add("天蝎喝牛奶");
        mlist_ry.add("射手喝果汁");
        mlist_ry.add("魔羯喝啤酒");
        mlist_ry.add("水瓶喝五粮液");
        mlist_ry.add("狮子喝雪碧");
        mlist_ry.add("双鱼喝果粒橙");
        hotRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotAdapter adapter = new HotAdapter(mlist_ry,getActivity(),mlist);
        hotRecyclerview.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
