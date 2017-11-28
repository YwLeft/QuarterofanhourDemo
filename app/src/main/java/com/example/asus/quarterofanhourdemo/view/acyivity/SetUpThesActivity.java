package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建时间  2017/11/28 15:36
 * 创建人    gaozhijie
 * 类描述      设置页面
 */
public class SetUpThesActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.set_teturn)
    RadioButton setTeturn;
    @BindView(R.id.return_login)
    Button returnLogin;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_up_the;
    }

    @Override
    public void initView() {
        setTeturn.setOnClickListener(this);
        returnLogin.setOnClickListener(this);
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
        switch (view.getId()) {
            case R.id.set_teturn:
                finish();
                break;
            case R.id.return_login:
                Intent intent = new Intent(this,LoginOneActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
