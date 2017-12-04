package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/12/1 19:48
 * 创建人    gaozhijie
 * 类描述     我的关注适配器
 */
public class MyFocusonAdapter extends RecyclerView.Adapter<MyFocusonAdapter.ViewHolder> {
    public Context context;

    public MyFocusonAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myfocuson_item, parent, false);
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
