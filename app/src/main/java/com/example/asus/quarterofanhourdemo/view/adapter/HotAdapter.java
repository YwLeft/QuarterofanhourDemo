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
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * 创建时间  2017/11/25 10:05
 * 创建人    gaozhijie
 * 类描述    热门/关注的适配器
 */
public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mHeaderCount = 1;
    List<String> mlist_ry;
    List<Integer> mlist;
    public HotAdapter(List<String> mlist_ry, Context context, List<Integer> mlistRy) {
        this.mContext = context;
        this.mlist_ry = mlist_ry;
        this.mlist = mlistRy;
        mLayoutInflater = LayoutInflater.from(context);
    }


    public int getContentItemCount() {
        return mlist_ry.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ITEM_TYPE_HEADER;
        } else {
            return ITEM_TYPE_CONTENT;
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recommend_title);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private Banner banneritem;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            banneritem = itemView.findViewById(R.id.banner);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.banners, parent, false));
        } else if (viewType == mHeaderCount) {
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.recommended_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).banneritem.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);

                }
            });
            //设置图片集合
            ((HeaderViewHolder) holder).banneritem.setImages(mlist);
            //设置轮播时间
            ((HeaderViewHolder) holder).banneritem.setDelayTime(1500);
            //设置指示器位置（当banner模式中有指示器时）
            ((HeaderViewHolder) holder).banneritem.setBannerStyle(BannerConfig.NOT_INDICATOR);
            //banner设置方法全部调用完毕时最后调用
            ((HeaderViewHolder) holder).banneritem.start();
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textView.setText(mlist_ry.get(position - mHeaderCount));
        }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount();
    }
}
