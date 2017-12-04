package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;
import com.example.asus.quarterofanhourdemo.base.Basebean;
import com.example.asus.quarterofanhourdemo.model.net.MyApp;
import com.example.asus.quarterofanhourdemo.presenter.PublishedPresenter;
import com.example.asus.quarterofanhourdemo.view.iview.PublishedView;

import butterknife.BindView;

/**
 * 创建时间  2017/12/1 11:26
 * 创建人    gaozhijie
 * 类描述    发布段子
 */
public class PublishedActivity extends BaseActivity implements View.OnClickListener, PublishedView {
    @BindView(R.id.published_call_off)
    TextView publishedCallOff;
    @BindView(R.id.published)
    TextView published;
    @BindView(R.id.published_woods)
    EditText publishedWoods;
    @BindView(R.id.published_add_image)
    ImageView publishedAddImage;
    private PublishedPresenter presenter;

    @Override
    public BaseDataPresenter initPresenter() {
        presenter = new PublishedPresenter(this);
        return presenter;
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
                String string = publishedWoods.getText().toString().trim();
                if (string != null && string.length()>0){
                    presenter.getData(MyApp.getUserInfoSp().getString("userId",""),string);
                }else {
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.published_add_image:
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
    public void onGetPublishedSucceed(Basebean bean) {
        int  code = Integer.parseInt(bean.getCode());
        String msg = bean.getMsg();
        if (code == 0){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PublishedActivity.this,SuccessActivity.class);
            startActivity(intent);
            finish();
        }else if (code == 1){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetPublishedFail(String e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}
