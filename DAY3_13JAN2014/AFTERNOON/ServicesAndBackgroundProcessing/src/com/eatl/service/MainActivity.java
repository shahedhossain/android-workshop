package com.eatl.service;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {


	Button StartBtn, StopBtn;
	Intent serviceIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		StartBtn = (Button)findViewById(R.id.buttonServiceOn);
		StopBtn = (Button)findViewById(R.id.buttonServiceOff);

		

		StartBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				serviceIntent = new Intent(MainActivity.this,MyService.class);
				startService(serviceIntent);
			}
		});



		StopBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				serviceIntent = new Intent(MainActivity.this,MyService.class);
				stopService(serviceIntent);
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
