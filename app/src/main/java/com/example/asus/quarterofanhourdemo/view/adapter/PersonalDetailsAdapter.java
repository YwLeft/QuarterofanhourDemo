package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.PersonalDetailsBean;
import com.example.asus.quarterofanhourdemo.view.custom.AnimationImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 创建时间  2017/12/16 9:23
 * 创建人    gaozhijie
 * 类描述    个人详情页面适配器
 */
public class PersonalDetailsAdapter extends RecyclerView.Adapter<PersonalDetailsAdapter.ViewHolder> {

    List<PersonalDetailsBean> data;
    Context context;

    public PersonalDetailsAdapter(List<PersonalDetailsBean> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PersonalDetailsBean bean = data.get(position);
        holder.recommendTime.setText(bean.getCreateTime());
        if (bean.getWorkDesc() != null&&bean.getWorkDesc().length()!=0) {
            holder.recommendItemTitle.setText(bean.getWorkDesc());
        }

        //视频
        holder.videoplayer.setUp(bean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST);

        //封面
        Glide.with(context)
                .load(bean.getCover())
                .into(holder.videoplayer.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recommend_item_tou)
        AnimationImage recommendItemTou;
        @BindView(R.id.recommend_time)
        TextView recommendTime;
        @BindView(R.id.recommend_item_title)
        TextView recommendItemTitle;
        @BindView(R.id.videoplayer)
        JCVideoPlayerStandard videoplayer;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
