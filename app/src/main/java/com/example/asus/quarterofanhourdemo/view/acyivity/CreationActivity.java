package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/29 9:13
 * 创建人    gaozhijie
 * 类描述    创作页面
 */
public class CreationActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.creation_call_off)
    TextView creationCallOff;
    @BindView(R.id.creation_video)
    LinearLayout creationVideo;
    @BindView(R.id.creation_crosstalk)
    LinearLayout creationCrosstalk;

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
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.creation_call_off:
                finish();
                break;
            default:
                break;
        }
    }
}
