package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;


import butterknife.BindView;

/**
 * 创建时间  2017/11/29 9:13
 * 创建人    gaozhijie
 * 类描述    创作页面
 */
public class CreationActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.creation_call_off)
    TextView creationCallOff;
    @BindView(R.id.creation_video)
    TextView creationVideo;
    @BindView(R.id.creation_crosstalk)
    TextView creationCrosstalk;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_creation;
    }

    @Override
    public void initView() {
        creationCallOff.setOnClickListener(this);
        creationVideo.setOnClickListener(this);
        creationCrosstalk.setOnClickListener(this);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.creation_call_off:
                finish();
                break;
            case R.id.creation_video:
                Toast.makeText(this, "视频正在快马加鞭进行中", Toast.LENGTH_SHORT).show();
                break;
            case R.id.creation_crosstalk:
                Intent intent = new Intent(this, PublishedActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
