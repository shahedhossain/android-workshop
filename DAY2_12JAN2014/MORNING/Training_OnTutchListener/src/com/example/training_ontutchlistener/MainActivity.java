package com.example.training_ontutchlistener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	Button imageButton=(Button)findViewById(R.id.imagebutton);
	imageButton.setOnTouchListener(
    		new View.OnTouchListener() {
    			public boolean onTouch(View v, MotionEvent m) {
    				Toast.makeText(getApplicationContext(), "Image Button Touched", Toast.LENGTH_SHORT).show();    				
    			    return true;
    			}
    		}
    );

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
