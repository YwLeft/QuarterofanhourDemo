package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.view.custom.AnimationImage;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/12/1 19:48
 * 创建人    gaozhijie
 * 类描述    我的消息适配器
 */
public class MyDriectAdapter extends RecyclerView.Adapter<MyDriectAdapter.ViewHolder> {
    public Context context;


    public MyDriectAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mydriect_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.my_driect_item_tou)
        AnimationImage myDriectItemTou;
        @BindView(R.id.my_driect_title)
        TextView myDriectTitle;
        @BindView(R.id.my_driect_time)
        TextView myDriectTime;
        @BindView(R.id.my_driect_wood)
        TextView myDriectWood;
        @BindView(R.id.my_driect_item_title)
        ImageView myDriectItemTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
