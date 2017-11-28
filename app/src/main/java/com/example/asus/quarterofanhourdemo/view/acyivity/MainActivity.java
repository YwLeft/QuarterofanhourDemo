package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.asus.quarterofanhourdemo.R;
import com.example.asus.quarterofanhourdemo.base.BaseActivity;
import com.example.asus.quarterofanhourdemo.base.BaseDataPresenter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 引导页
 */
public class MainActivity extends BaseActivity {
    private int time_count = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (time_count == 0) {
                Intent intent = new Intent(MainActivity.this, TheHomePageActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    private Timer timer;

    @Override
    public BaseDataPresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        // TODO Auto-generated method stub
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (time_count > 0) {
                    time_count--;
                    handler.sendEmptyMessage(0);
                }
            }
        }, 0, 1000);
    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
