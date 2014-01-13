package com.example.training_dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Dialog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{

		switch (item.getItemId())
		{
		case R.id.about:
			// Single menu item is selected do something
			// Ex: launching new activity/screen or show alert message
			Toast.makeText(Dialog.this, "Android Logo", Toast.LENGTH_SHORT).show();
			return true;

		case R.id.save:
			Toast.makeText(Dialog.this, "Image Saved", Toast.LENGTH_SHORT).show();
			return true;

		case R.id.share:
			Toast.makeText(Dialog.this, "Sharing Compleate", Toast.LENGTH_SHORT).show();
			return true;


		case R.id.delete:
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you confirm for delation?");
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					
					ImageView im=(ImageView)findViewById(R.id.image);
					im.setVisibility(View.INVISIBLE);
				}
			});
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					// User cancelled the dialog
				}
			});
			// Set other dialog properties


			// Create the AlertDialog
			AlertDialog dialog = builder.create();
			dialog.show();
			return true;
		}


		case R.id.zoom:
			Toast.makeText(Dialog.this, "Create Zooming Activity", Toast.LENGTH_SHORT).show();
			return true;


		default:
			return super.onOptionsItemSelected(item);
		}
	}    

}
