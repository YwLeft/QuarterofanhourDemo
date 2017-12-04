package com.example.asus.quarterofanhourdemo.view.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    List<CrosstalkBean> mlist;

    public CrosstalkAdapter(List<CrosstalkBean> mlist, Context context) {
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        CrosstalkBean dataBean = mlist.get(position);
        holder.recommendTime.setText(dataBean.getCreateTime());
        holder.recommendName.setText(dataBean.getUser().getNickname());
        holder.recommendItemTitle.setText(dataBean.getContent());

        holder.recommendItemDong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.recommendItemDong5.setVisibility(View.GONE);
                holder.recommendItemDong1.setVisibility(View.VISIBLE);
                holder.recommendItemDong2.setVisibility(View.VISIBLE);
                holder.recommendItemDong3.setVisibility(View.VISIBLE);
                holder.recommendItemDong4.setVisibility(View.VISIBLE);
                //设置动画时间
                int duration = 1000;
                //相邻ImageView运动角度式22.5度
                int distance = holder.recommendItemDong4.getWidth() + 16;
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


                ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong4, trun).setDuration(duration);
                ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong3, p1, trun).setDuration(duration);
                ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong2, p2, trun).setDuration(duration);
                ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong1, p3, trun).setDuration(duration);

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
        holder.recommendItemDong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.recommendItemDong4.setVisibility(View.GONE);
                holder.recommendItemDong5.setVisibility(View.VISIBLE);

                //设置动画时间
                int duration = 1000;
                //相邻ImageView运动角度式22.5度
                int distance = holder.recommendItemDong5.getWidth() + 16;
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

                ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong5, trun).setDuration(duration);
                ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong2, p1, trun).setDuration(duration);
                ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong1, p2, trun).setDuration(duration);
                ObjectAnimator animator4 = ObjectAnimator.ofPropertyValuesHolder(holder.recommendItemDong3, p3, trun).setDuration(duration);

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
                        holder.recommendItemDong1.setVisibility(View.GONE);
                        holder.recommendItemDong2.setVisibility(View.GONE);
                        holder.recommendItemDong3.setVisibility(View.GONE);
                        holder.recommendItemDong4.setVisibility(View.GONE);
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
        Glide.with(context)
                .load(dataBean.getUser().getIcon())
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
                //.placeholder(R.mipmap.ic_launcher_round)
                .transform(new GlideCircleTransform(context))

                .into(holder.recommendItemTou);

        if (dataBean.getImgUrls() != null && dataBean.getImgUrls().length() != 0) {
            String[] split = dataBean.getImgUrls().split("\\|");
            holder.creationRecyclerview.setLayoutManager(new GridLayoutManager(context, 3));

            CrosstalkItemAdapter adapter = new CrosstalkItemAdapter(split, context);

            holder.creationRecyclerview.setAdapter(adapter);
        }


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
        @BindView(R.id.recommend_item_title)
        TextView recommendItemTitle;
        @BindView(R.id.creation_recyclerview)
        RecyclerView creationRecyclerview;
        @BindView(R.id.recommend_item_dong1)
        RadioButton recommendItemDong1;
        @BindView(R.id.recommend_item_dong2)
        RadioButton recommendItemDong2;
        @BindView(R.id.recommend_item_dong3)
        RadioButton  recommendItemDong3;
        @BindView(R.id.recommend_item_dong4)
        RadioButton recommendItemDong4;
        @BindView(R.id.recommend_item_dong5)
        RadioButton recommendItemDong5;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
