package com.eatl.sharedpref;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class Login extends Activity{
	private String username,password;
	private Button ok;
	private EditText editTextUsername,editTextPassword;
	private CheckBox saveLoginCheckBox;
	private SharedPreferences loginPreferences;
	private SharedPreferences.Editor loginPrefsEditor;
	private Boolean saveLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		ok = (Button)findViewById(R.id.buttonLogin);
	
		editTextUsername = (EditText)findViewById(R.id.editTextUsername);
		editTextPassword = (EditText)findViewById(R.id.editTextPassword);
		saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
		
		loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
		loginPrefsEditor = loginPreferences.edit();

		saveLogin = loginPreferences.getBoolean("saveLogin", false);
		
		if (saveLogin == true) {
			editTextUsername.setText(loginPreferences.getString("username", ""));
			editTextPassword.setText(loginPreferences.getString("password", ""));
			saveLoginCheckBox.setChecked(true);
		}
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				//imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);

				username = editTextUsername.getText().toString();
				password = editTextPassword.getText().toString();	
						
				
				if (saveLoginCheckBox.isChecked()) {
					loginPrefsEditor.putBoolean("saveLogin", true);
				
					loginPrefsEditor.putString("username", username);
					loginPrefsEditor.putString("password", password);
					loginPrefsEditor.commit();
				
				} 
				
				
				else {
					loginPrefsEditor.clear();
					loginPrefsEditor.commit();
				}

				Intent i = new Intent(Login.this, Welcome.class);
				startActivity(i);
				finish();
			}
		});
	}

	


}
