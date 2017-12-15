package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.bean.LoginBean;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.presenter.LoginPresenter;
import com.example.asus.quarterofanhourdemo.view.iview.LoginView;

import butterknife.BindView;

/**
 * 创建时间  2017/11/28 19:11
 * 创建人    gaozhijie
 * 类描述     登陆第二个界面
 */
public class LoginTwoActivity extends BaseActivity implements View.OnClickListener, LoginView {

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
    public LoginPresenter presenter;

    @Override
    public BaseDataPresenter initPresenter() {
        presenter = new LoginPresenter(this);
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_two;
    }

    @Override
    public void initView() {
        loginTwoImage.setOnClickListener(this);
        loginTwoRegistered.setOnClickListener(this);
        loginTwoLogin.setOnClickListener(this);
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
            case R.id.login_two_login:
                String mobile = loginTwoAccount.getText().toString().trim();
                String password = loginTwoPassword.getText().toString().trim();
                presenter.getData(mobile,password);
                break;
            case R.id.login_two_registered:
                Intent intent = new Intent(this,ReferrerActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onGetLoginSucceed(Basebean<LoginBean> bean) {
        int code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code ==0){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginTwoActivity.this,TheHomePageActivity.class);
            SharedPreferences sp = MyApp.getUserInfoSp();
            SharedPreferences.Editor editor =  sp.edit();
            editor.putString("userId", String.valueOf(bean.getData().getUid()));
            editor.putString("userIcon", String.valueOf(bean.getData().getIcon()));
            editor.putString("usertoken", String.valueOf(bean.getData().getToken()));
            editor.putString("userNickname", String.valueOf(bean.getData().getNickname()));
            editor.putBoolean("loginboolen",true);//存为登录中状态 true
            editor.commit();
            startActivity(intent);
        }else if (code == 1){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetLoginFail(String e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}
