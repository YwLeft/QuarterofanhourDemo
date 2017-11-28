package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/28 19:11
 * 创建人    gaozhijie
 * 类描述     登陆第二个界面
 */
public class LoginTwoActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.login_two_registered)
    TextView loginTwoRegistered;
    @BindView(R.id.login_two_account)
    EditText loginTwoAccount;
    @BindView(R.id.login_two_password)
    EditText loginTwoPassword;
    @BindView(R.id.login_two_login)
    Button loginTwoLogin;
    @BindView(R.id.login_two_Forgot_password)
    TextView loginTwoForgotPassword;
    @BindView(R.id.login_two_Visitors_login)
    TextView loginTwoVisitorsLogin;
    @BindView(R.id.login_two_image)
    ImageView loginTwoImage;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_two;
    }

    @Override
    public void initView() {
        loginTwoImage.setOnClickListener(this);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_two_image:
                finish();
                break;
            case R.id.login_one_title:
//                Intent intent = new Intent(this,LoginOneActivity.class);
//                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
