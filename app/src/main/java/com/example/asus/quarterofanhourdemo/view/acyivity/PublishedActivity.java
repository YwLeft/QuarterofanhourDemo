package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;

/**
 * 创建时间  2017/12/1 11:26
 * 创建人    gaozhijie
 * 类描述    发布段子
 */
public class PublishedActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.published_call_off)
    TextView publishedCallOff;
    @BindView(R.id.published)
    TextView published;
    @BindView(R.id.published_woods)
    EditText publishedWoods;
    @BindView(R.id.published_add_image)
    ImageView publishedAddImage;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_published;
    }

    @Override
    public void initView() {
        publishedCallOff.setOnClickListener(this);
        published.setOnClickListener(this);
        publishedAddImage.setOnClickListener(this);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.published_call_off:
                finish();
                break;
            case R.id.published:
                break;
            case R.id.published_add_image:
                break;
            default:
                break;
        }
    }
}
