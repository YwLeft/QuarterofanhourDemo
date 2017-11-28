package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.CrosstalkBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/27 18:52
 * 创建人    gaozhijie
 * 类描述      段子适配器
 */
public class CrosstalkAdapter extends RecyclerView.Adapter<CrosstalkAdapter.ViewHolder> {
    List<CrosstalkBean.DataBean.UserBean> mlist_user;
    Context context;



    public CrosstalkAdapter(List<CrosstalkBean.DataBean.UserBean> mlist_user, Context context) {
        this.context = context;
        this.mlist_user = mlist_user;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crosstalk_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recommendTime.setText(mlist_user.get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return mlist_user == null ? 0 : mlist_user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recommend_time)
        TextView recommendTime;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
