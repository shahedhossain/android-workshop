package com.example.framebyframeanimationproject;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class frameact extends Activity {

	AnimationDrawable logoAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		
		ImageView player = (ImageView) findViewById(R.id.player);
		player.setImageResource(R.drawable.frameanimation);
		logoAnimation = (AnimationDrawable) player.getDrawable();
		logoAnimation.start();
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
