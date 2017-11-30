package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;
import com.example.asus.quarterofanhourdemo.view.iview.GlideCircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/27 18:52
 * 创建人    gaozhijie
 * 类描述      段子适配器
 */
public class CrosstalkAdapter extends RecyclerView.Adapter<CrosstalkAdapter.ViewHolder> {
    Context context;
    List<CrosstalkBean.DataBean> mlist;

    public CrosstalkAdapter(List<CrosstalkBean.DataBean> mlist, Context context) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crosstalk_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CrosstalkBean.DataBean dataBean = mlist.get(position);
        holder.recommendTime.setText(dataBean.getCreateTime());
        holder.recommendName.setText(dataBean.getUser().getNickname());
        Glide.with(context)
                .load(dataBean.getUser().getIcon())
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
                //.placeholder(R.mipmap.ic_launcher_round)
                .transform(new GlideCircleTransform(context))
                .into(holder.recommendItemTou);

    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recommend_time)
        TextView recommendTime;
        @BindView(R.id.recommend_item_tous)
        ImageView recommendItemTou;
        @BindView(R.id.recommend_name)
        TextView recommendName;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
