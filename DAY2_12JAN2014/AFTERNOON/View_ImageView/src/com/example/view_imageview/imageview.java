package com.example.view_imageview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.ImageView;

public class imageview extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView im;
		im=(ImageView)findViewById(R.id.image);
		//im.setBackground(getResources().getDrawable(R.drawable.ic_launcher));
		im.setBackgroundColor(Color.BLUE);
		//im.setId(im);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
