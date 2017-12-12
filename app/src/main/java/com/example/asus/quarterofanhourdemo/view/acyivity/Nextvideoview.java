package com.example.asus.quarterofanhourdemo.view.acyivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.asus.quarterofanhourdemo.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;


public class Nextvideoview extends AppCompatActivity implements OnClickListener {
	private MediaPlayer mediaPlayer;
	private SurfaceView mSurfaceView;
	private SurfaceHolder holder;
	private String filepath;
	private SeekBar mseekbar;
	private Timer timer;
	private TextView mtimer;
	private Handler hand = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vidoview);

		mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);
		mseekbar = (SeekBar) findViewById(R.id.seekbae);
		mtimer = (TextView) findViewById(R.id.time);

		//mediaPlayer=MediaPlayer.create(this,R.raw.yy);
		mediaPlayer = new MediaPlayer();
		timer = new Timer();

		mSurfaceView.setOnClickListener(this);
		
		mseekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				mediaPlayer.seekTo(seekBar.getProgress());

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			try {
				holder = mSurfaceView.getHolder();
				filepath = Environment.getExternalStorageDirectory().getPath();
//				mediaPlayer.setDataSource(filepath+"/DCIM/Camera/yyl.mp4");
				mediaPlayer.setDataSource(filepath+"/Movies/yyl.mp4");
				Uri data = Uri.parse(filepath+"/Movies/yyl.mp4");
//				Uri data = Uri.parse(filepath+"/DCIM/Camera/yyl.mp4");
				mediaPlayer = MediaPlayer.create(this, data);
				mseekbar.setMax(mediaPlayer.getDuration());
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}if(!mediaPlayer.isPlaying()){
				
				mediaPlayer.setDisplay(holder);
				mediaPlayer.start();
				timer.schedule(new Task(), 0, 1000);
			}else{
			
				mediaPlayer.pause();;
			}

		 
	}

	class Task extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (mediaPlayer.isPlaying()) {
				final int position = mediaPlayer.getCurrentPosition();
				mseekbar.setProgress(position);
				hand.post(new Runnable() {
					@Override
					public void run() {
						SimpleDateFormat format = new SimpleDateFormat("mm:ss");
						String format2 = format.format(position);
						String format3 = format.format(mediaPlayer
								.getDuration());
						mtimer.setText(format2 + "/" + format3);

					}
				});

			}
		}
	}
}
