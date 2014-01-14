package com.eatl.sharedpref;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class Welcome extends Activity {
	private SharedPreferences loginPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.welcome);
		
		loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
		
		String un=loginPreferences.getString("username", "");
		TextView tv=(TextView)findViewById(R.id.textView1);
		tv.setText("Welcome:"+un);

	}
	

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	

			finish();
	
	}

}