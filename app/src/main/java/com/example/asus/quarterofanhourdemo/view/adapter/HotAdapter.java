package com.example.asus.quarterofanhourdemo.view.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.model.bean.RecommendHotBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

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
    List<RecommendHotBean> mlist_ry;
    List<Integer> mlist;

    public HotAdapter(List<RecommendHotBean> data, Context context, List<Integer> mlist) {
        this.mContext = context;
        this.mlist_ry = data;
        this.mlist = mlist;
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
        private TextView textView_title,textView_time,textView_item_title,textone,texttwo;
        private RadioButton donghua1, donghua2, donghua3, donghua4, donghua5;
        private ImageView imageView_item;
        private final JCVideoPlayerStandard viewById;


        public ContentViewHolder(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.recommend_title);
            textView_time = itemView.findViewById(R.id.recommend_time);
            textView_item_title = itemView.findViewById(R.id.recommend_item_title);
            imageView_item = itemView.findViewById(R.id.recommend_item_tou);
            textone = itemView.findViewById(R.id.recommend_item_commentsone);
            texttwo = itemView.findViewById(R.id.recommend_item_commentstwo);

            viewById = itemView.findViewById(R.id.videoplayer);
            donghua1 = itemView.findViewById(R.id.recommend_item_dong1);
            donghua2 = itemView.findViewById(R.id.recommend_item_dong2);
            donghua3 = itemView.findViewById(R.id.recommend_item_dong3);
            donghua4 = itemView.findViewById(R.id.recommend_item_dong4);
            donghua5 = itemView.findViewById(R.id.recommend_item_dong5);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private Banner banneritem;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            banneritem = itemView.findViewById(R.id.banner);
        }
    }

   /* *//**
     * 自定义的接口
     * 并暴露
     *//*
    public interface setitemonclick {
        void setonitemhol(View view);
    }

    setitemonclick setitemonclick;


    public void setSetitemonclick(HotAdapter.setitemonclick setitemonclick) {
        this.setitemonclick = setitemonclick;
    }*/

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.banners, parent, false));
        } else if (viewType == mHeaderCount) {
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.recommended_item, parent, false));
        }
        return null;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
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

           /* //条目的点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setitemonclick != null) {
                        setitemonclick.setonitemhol(v);
                    }
                }
            });*/
            RecommendHotBean recommendHotBean = mlist_ry.get(position - mHeaderCount);
            //名字
            ((ContentViewHolder) holder).textView_title.setText(recommendHotBean.getUser().getNickname());
            //时间
            ((ContentViewHolder) holder).textView_time.setText(recommendHotBean.getCreateTime());
            //内容
            ((ContentViewHolder) holder).textView_item_title.setText(recommendHotBean.getWorkDesc());
            //头像
            Glide.with(mContext)
                    .load(recommendHotBean.getUser().getIcon())
                    .into(((ContentViewHolder) holder).imageView_item);
            //视频
            ((ContentViewHolder) holder).viewById.setUp(recommendHotBean.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST);

            //封面
            Glide.with(mContext)
                    .load(recommendHotBean.getCover())
                    .into(((ContentViewHolder) holder).viewById.thumbImageView);

            //评论改变个别颜色
            SpannableString spannableString = new SpannableString(((ContentViewHolder) holder).textone.getText().toString());
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#03A9F4"));
            spannableString.setSpan(colorSpan, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            ((ContentViewHolder) holder).textone.setText(spannableString);

            //评论改变个别颜色
            SpannableString spannableString1 = new SpannableString(((ContentViewHolder) holder).texttwo.getText().toString());
            ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#03A9F4"));
            spannableString1.setSpan(colorSpan1, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            ((ContentViewHolder) holder).texttwo.setText(spannableString1);


            ((ContentViewHolder) holder).donghua5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ContentViewHolder) holder).donghua5.setVisibility(View.GONE);
                    ((ContentViewHolder) holder).donghua1.setVisibility(View.VISIBLE);
                    ((ContentViewHolder) holder).donghua2.setVisibility(View.VISIBLE);
                    ((ContentViewHolder) holder).donghua3.setVisibility(View.VISIBLE);
                    ((ContentViewHolder) holder).donghua4.setVisibility(View.VISIBLE);
                    //设置动画时间
                    int duration = 1000;
                    //相邻ImageView运动角度式22.5度
                    int distance = ((ContentViewHolder) holder).donghua4.getWidth() + 16;
                    //旋转的动画
                    PropertyValuesHolder trun = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
                    PropertyValuesHolder p1;
                    PropertyValuesHolder p2;
                    PropertyValuesHolder p3;

                    //第一个平移的动画
                    p1 = PropertyValuesHolder.ofFloat("TranslationX", 0f, -distance);
                    //icon2
                    p2 = PropertyValuesHolder.ofFloat("TranslationX", 0f, -(distance * 2));
                    //icon3
                    p3 = PropertyValuesHolder.ofFloat("TranslationX", 0f, -(distance * 3));


                    ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua4, trun).setDuration(duration);
                    ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua3, p1, trun).setDuration(duration);
                    ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua2, p2, trun).setDuration(duration);
                    ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua1, p3, trun).setDuration(duration);

                    //添加自由落体效果插值器
                    animator1.setInterpolator(new DecelerateInterpolator());
                    animator2.setInterpolator(new DecelerateInterpolator());
                    animator3.setInterpolator(new DecelerateInterpolator());
                    animator4.setInterpolator(new DecelerateInterpolator());

                    //启动动画
                    animator1.start();
                    animator2.start();
                    animator3.start();
                    animator4.start();


                }
            });
            ((ContentViewHolder) holder).donghua4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ContentViewHolder) holder).donghua4.setVisibility(View.GONE);
                    ((ContentViewHolder) holder).donghua5.setVisibility(View.VISIBLE);

                    //设置动画时间
                    int duration = 1000;
                    //相邻ImageView运动角度式22.5度
                    int distance = ((ContentViewHolder) holder).donghua5.getWidth() + 16;
                    //旋转的动画
                    PropertyValuesHolder trun = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
                    PropertyValuesHolder p1;
                    PropertyValuesHolder p2;
                    PropertyValuesHolder p3;

                    //第一个平移的动画
                    p1 = PropertyValuesHolder.ofFloat("TranslationX", -distance, 0);
                    //icon2
                    p2 = PropertyValuesHolder.ofFloat("TranslationX", -(distance * 2), 0);
                    //icon3
                    p3 = PropertyValuesHolder.ofFloat("TranslationX", -(distance * 3), 0);

                    ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua5, trun).setDuration(duration);
                    ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua2, p1, trun).setDuration(duration);
                    ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua1, p2, trun).setDuration(duration);
                    ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(((ContentViewHolder) holder).donghua3, p3, trun).setDuration(duration);

                    //添加自由落体效果插值器
                    animator1.setInterpolator(new DecelerateInterpolator());
                    animator2.setInterpolator(new DecelerateInterpolator());
                    animator3.setInterpolator(new DecelerateInterpolator());
                    animator4.setInterpolator(new DecelerateInterpolator());

                    //启动动画
                    animator1.start();
                    animator2.start();
                    animator3.start();
                    animator4.start();

                    animator1.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            ((ContentViewHolder) holder).donghua1.setVisibility(View.GONE);
                            ((ContentViewHolder) holder).donghua2.setVisibility(View.GONE);
                            ((ContentViewHolder) holder).donghua3.setVisibility(View.GONE);
                            ((ContentViewHolder) holder).donghua4.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount();
    }
}
