package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;

/**
 * 类描述    登陆第一个界面
 */
public class LoginOneActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.login_one_image)
    ImageView loginOneImage;
    @BindView(R.id.login_one_title)
    TextView loginOneTitle;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_one;
    }

    @Override
    public void initView() {
        loginOneImage.setOnClickListener(this);
        loginOneTitle.setOnClickListener(this);

    }

    @Override
    protected boolean NoTile() {
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_one_image:
                finish();
                break;
            case R.id.login_one_title:
                Intent intent = new Intent(this, LoginTwoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
