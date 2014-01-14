package com.eatl.netcheck;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


public class detect extends Activity {

	// flag for Internet connection status
	Boolean isInternetPresent = false;

	// Connection detector class
	ConnectionDetector cd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		// creating connection detector class instance
		cd = new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();

		// check for Internet status
		if (isInternetPresent) {
			// Internet Connection is Present
			// make HTTP requests
			Intent in = new Intent(detect.this,
					Login.class);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(in);
			finish();
		} else {
			// Internet connection is not present
			// Ask user to connect to Internet
			showAlertDialog(detect.this, "No Internet Connection",
					"You are not connected to the internet.", false);
		}
		/**
		 * Check Internet status button click event
		 * */


	}

	/**
	 * Function to display simple Alert Dialog
	 * @param context - application context
	 * @param title - alert dialog title
	 * @param message - alert message
	 * @param status - success/failure (used to set icon)
	 * */
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message, Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		// Setting alert dialog icon

		// Setting OK Button
		alertDialog.setButton("Exit", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				finish();

			}
		});

		// Showing Alert Message
		alertDialog.show();
	}
}