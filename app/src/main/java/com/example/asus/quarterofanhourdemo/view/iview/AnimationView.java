package com.example.asus.quarterofanhourdemo.view.iview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;


/**
 * 创建时间  2017/11/17 13:34
 * 创建人    gaozhijie
 * 类描述    加载本地动图
 */
public class AnimationView extends LinearLayout {
    private ImageView imageView;

    public AnimationView(Context context) {
        super(context);
    }

    public AnimationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    private void initview(Context context) {
        View view = inflate(context, R.layout.my_messages_image,this);
        imageView = view.findViewById(R.id.my_alerts_messages_image);
        int resourceId = R.drawable.raw_1500868199;
//        int resourceId = R.drawable.raw_1500020546;
        Glide.with(context).load(resourceId).into(imageView);
    }
}
