package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.MyFocusonBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/12/1 19:48
 * 创建人    gaozhijie
 * 类描述     我的关注适配器
 */
public class MyFocusonAdapter extends RecyclerView.Adapter<MyFocusonAdapter.ViewHolder> {
    public Context context;
    List<MyFocusonBean> data;
    public MyFocusonAdapter(Context context, List<MyFocusonBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myfocuson_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyFocusonBean bean = data.get(position);
        Glide.with(context).load(bean.getIcon()).into(holder.myFocusoItemTou);
        holder.myFocusoTime.setText(bean.getCreatetime());
        holder.myFocusoTitle.setText(bean.getNickname());
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.my_focuso_item_tou)
        ImageView myFocusoItemTou;
        @BindView(R.id.my_focuso_title)
        TextView myFocusoTitle;
        @BindView(R.id.my_focuso_wood)
        TextView myFocusoWood;
        @BindView(R.id.my_focuso_time)
        RadioButton myFocusoTime;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
