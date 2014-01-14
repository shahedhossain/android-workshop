package com.eatl.videoplayproject;

import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;


public class VideoPlayer extends Activity implements SurfaceHolder.Callback{

	//MediaPlayer mediaPlayer;
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;

	VideoView mVideoView;
	Button buttonPlayVideo;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonPlayVideo = (Button)findViewById(R.id.play);
		//buttonPauseVideo=(Button)findViewById(R.id.pause);

		getWindow().setFormat(PixelFormat.UNKNOWN);
		mVideoView = (VideoView)findViewById(R.id.videoview);

		buttonPlayVideo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String uriPath = "android.resource://com.eatl.videoplayproject/"+R.raw.k;
				Uri uri = Uri.parse(uriPath);
				mVideoView.setVideoURI(uri);
				mVideoView.requestFocus();
				mVideoView.start();

			}
		});


	

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}
}