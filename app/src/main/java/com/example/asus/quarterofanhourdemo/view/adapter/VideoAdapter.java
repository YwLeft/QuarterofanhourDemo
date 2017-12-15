package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.VideoHotBean;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/27 18:52
 * 创建人    gaozhijie
 * 类描述      热门/附近  适配器
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    Context context;
    List<VideoHotBean> mlist;


    public VideoAdapter(List<VideoHotBean> data, Context context) {
        this.context = context;
        this.mlist = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoHotBean videoHotBean = mlist.get(position);


        ViewGroup.LayoutParams layoutParams = holder.videoItemImage.getLayoutParams();
        Random random = new Random();
        int i = random.nextInt(300);
        layoutParams.height = 300 + i;
//        //视频
//         holder.videoItemImage.setUp(videoHotBean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST);

        //封面
        Glide.with(context)
                .load(videoHotBean.getCover())
                .into(holder.videoItemImage);
        holder.itemView.setTag(position);
        //条目的点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setitemonclick != null) {
                    setitemonclick.setonitemhol(v, (Integer) v.getTag());
                }
            }
        });

    }

    /*
      * 自定义的接口
      * 并暴露
      */
    public interface setitemonclick {
        void setonitemhol(View view, int position);
    }

    setitemonclick setitemonclick;


    public void setSetitemonclick(VideoAdapter.setitemonclick setitemonclick) {
        this.setitemonclick = setitemonclick;
    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_item_image)
        ImageView videoItemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
