package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;

import butterknife.BindView;

/**
 * 类描述      设置页面
 */
public class SetUpThesActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.set_teturn)
    RadioButton setTeturn;
    @BindView(R.id.return_login)
    Button returnLogin;
    private SharedPreferences sp;

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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.set_teturn:
                finish();
                break;
            case R.id.return_login:
                //读取本地保存的状态及文件
                sp = MyApp.getUserInfoSp();
                if (sp.getBoolean("loginboolen", false)) {
                    //弹出一个对话框
                    new AlertDialog.Builder(SetUpThesActivity.this)
                            .setTitle("确认您的选择")
                            .setMessage("确定退出登陆吗？亲")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @SuppressLint("CommitPrefEdits")
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //清空当前保存的状态和文件
                                    SharedPreferences.Editor edit = sp.edit();
                                    edit.clear();
                                    edit.commit();
                                    //退出后自动跳转到登陆页面
                                    Intent intent = new Intent(SetUpThesActivity.this, LoginOneActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("取消", null)
                            .create()
                            .show();
                } else {
                    //退出后自动跳转到登陆页面
                    Intent intent = new Intent(SetUpThesActivity.this, LoginOneActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
