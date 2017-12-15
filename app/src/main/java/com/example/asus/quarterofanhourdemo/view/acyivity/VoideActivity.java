package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.view.iview.AnimationImage;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 创建时间  2017/12/14 18:48
 * 创建人    gaozhijie
 * 类描述     视频详情
 */
public class VoideActivity extends BaseActivity {

    @BindView(R.id.item_videoplayer)
    JCVideoPlayerStandard itemVideoplayer;
    @BindView(R.id.video_item_return)
    ImageView videoItemReturn;
    @BindView(R.id.video_xiang_title)
    TextView videoXiangTitle;
    @BindView(R.id.video_xiang_count)
    TextView videoXiangCount;
    @BindView(R.id.video_item_tou)
    AnimationImage videoItemTou;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String tou = intent.getStringExtra("tou");
        String workDesc = intent.getStringExtra("workDesc");

        itemVideoplayer.setUp(url, JCVideoPlayer.SCREEN_LAYOUT_LIST);
        //头像
        Glide.with(this).load(tou).into(videoItemTou);
        //标题
        videoXiangTitle.setText(workDesc);
        //点击返回
        videoItemReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    protected boolean NoTile() {
        return true;
    }

}
