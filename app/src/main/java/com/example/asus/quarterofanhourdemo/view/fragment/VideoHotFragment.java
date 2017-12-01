package com.example.asus.quarterofanhourdemo.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.view.adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建时间  2017/11/29 19:28
 * 创建人    gaozhijie
 * 类描述    视频的关注页面
 */
public class VideoHotFragment extends BaseFragment {
    @BindView(R.id.video_hot)
    RecyclerView videoHot;
    private List<String> mlist = new ArrayList<>();

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video_hot;
    }

    @Override
    public void initView() {

        //模拟数据
        mlist.add("http://f2.kkmh.com/image/170218/niuuyj1n2.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170219/d9pfa8703.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170219/oj10grzpi.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170218/hvfdwq7jj.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170219/2xg7wnrux.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170218/j9mofw3lm.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170217/kps26d17y.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170217/yfhyw6zyg.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170219/s6hohqjy2.webp-w640");
        mlist.add("http://f2.kkmh.com/image/170218/kegurkre2.webp-w640");
        StaggeredGridLayoutManager manager= new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        new GridLayoutManager(getActivity(),3)
        videoHot.setLayoutManager(manager);
        VideoAdapter adapter = new VideoAdapter(mlist,getActivity());
        videoHot.setAdapter(adapter);
    }


}
