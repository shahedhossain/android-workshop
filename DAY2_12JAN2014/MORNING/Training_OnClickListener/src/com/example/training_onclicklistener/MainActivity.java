package com.example.training_onclicklistener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button imagebutton=(Button)findViewById(R.id.imagebutton);
		   
		imagebutton.setOnClickListener(new View.OnClickListener() 
		    { 
		public void onClick(View v) 
		                { 
		      
			        Toast.makeText(getApplicationContext(), "Button Pressed", Toast.LENGTH_SHORT).show();
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
