package com.example.asus.quarterofanhourdemo.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.BaseFragment;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.VideoHotBean;
import com.example.asus.quarterofanhourdemo.presenter.VideoHotPresenter;
import com.example.asus.quarterofanhourdemo.view.acyivity.VoideActivity;
import com.example.asus.quarterofanhourdemo.view.adapter.VideoAdapter;
import com.example.asus.quarterofanhourdemo.view.iview.VideoHotView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 创建时间  2017/11/29 19:28
 * 创建人    gaozhijie
 * 类描述    视频的关注页面
 */
public class VideoHotFragment extends BaseFragment implements VideoHotView, XRecyclerView.LoadingListener {
    @BindView(R.id.video_hot)
    XRecyclerView videoHot;
    private VideoHotPresenter presenter;
    private List<VideoHotBean> mlist = new ArrayList<>();
    private int page = 1;


    @Override
    public BaseDataPresenter initPresenter() {
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video_hot;
    }

    @Override
    public void initView() {
        Map<String, String> map = new HashMap<>();
        String pages = String.valueOf(page);
        map.put("page", pages);
        presenter = new VideoHotPresenter(this);
        presenter.getVideoHots(map);

    }

    private void initdata() {
        videoHot.setLoadingListener(this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        videoHot.setLayoutManager(manager);
        VideoAdapter adapter = new VideoAdapter(mlist, getActivity());
        videoHot.setAdapter(adapter);

        adapter.setSetitemonclick(new VideoAdapter.setitemonclick() {
            @Override
            public void setonitemhol(View view, int position) {
                String videoUrl = mlist.get(position).getVideoUrl();
                String workDesc = mlist.get(position).getWorkDesc();
                String icon = mlist.get(position).getUser().getIcon();
                Intent intent = new Intent(getActivity(), VoideActivity.class);
                intent.putExtra("url",videoUrl);
                intent.putExtra("tou",icon);
                intent.putExtra("workDesc",workDesc);
                startActivity(intent);
            }
        });
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onGetVideoHotSucceed(Basebean<List<VideoHotBean>> bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code == 0) {
            mlist.addAll(bean.getData());
            initdata();
        } else if (code == 1) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetVideoHotFail(String e) {
        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        page=1;
        mlist.clear();
        initView();
        stoprecycler();
    }

    private void stoprecycler() {
        videoHot.refreshComplete();
        videoHot.loadMoreComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        initView();
        stoprecycler();
    }
}
