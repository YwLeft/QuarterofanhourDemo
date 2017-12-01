package com.example.asus.quarterofanhourdemo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/30 10:57
 * 创建人    gaozhijie
 * 类描述     段子里面图片的适配器
 */
public class CrosstalkItemAdapter extends RecyclerView.Adapter<CrosstalkItemAdapter.ViewHolder> {

    String[] mlist_image;
    Context context;

    public CrosstalkItemAdapter(String[] mlist_image, Context context) {
        this.context = context;
        this.mlist_image = mlist_image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.creation_recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //String[] split = mlist_image[position].split("\\|");
        Glide.with(context)
                .load(mlist_image[position])
                .error(R.mipmap.ic_launcher)
                .into(holder.itemImagerc);
    }

    @Override
    public int getItemCount() {
        return mlist_image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_imagerc)
        ImageView itemImagerc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
