package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;

/**
 * 类描述     注册页面
 */
public class ReferrerActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.referrer_image)
    ImageView referrerImage;
    @BindView(R.id.referrer_registered)
    TextView referrerRegistered;
    @BindView(R.id.referrer_account)
    EditText referrerAccount;
    @BindView(R.id.referrer_password)
    EditText referrerPassword;
    @BindView(R.id.referrer_login)
    Button referrerLogin;
    @BindView(R.id.referrer_Visitors_login)
    TextView referrerVisitorsLogin;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_registered;
    }

    @Override
    public void initView() {
        referrerImage.setOnClickListener(this);
        referrerRegistered.setOnClickListener(this);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.referrer_image:
                finish();
                break;
            case R.id.referrer_registered:
                Intent intent = new Intent(this,LoginTwoActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
