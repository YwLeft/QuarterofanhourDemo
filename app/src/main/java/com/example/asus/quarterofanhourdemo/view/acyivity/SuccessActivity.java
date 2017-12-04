package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import butterknife.BindView;

/**
 * 创建时间  2017/12/1 18:48
 * 创建人    gaozhijie
 * 类描述     发布成功
 */
public class SuccessActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.success_call_off)
    RadioButton successCallOff;
    @BindView(R.id.success_return)
    Button successReturn;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_publishedsuccess;
    }

    @Override
    public void initView() {
        successCallOff.setOnClickListener(this);
        successReturn.setOnClickListener(this);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.success_call_off:
                finish();
                break;
            case R.id.success_return:
                Intent intent = new Intent(this,TheHomePageActivity.class);
                intent.putExtra("age",1);
                startActivity(intent);
                break;
        }

    }
}
