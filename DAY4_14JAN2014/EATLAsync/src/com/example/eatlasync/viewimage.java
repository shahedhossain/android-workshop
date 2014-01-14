package com.example.eatlasync;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;

public class viewimage extends Activity{
	static final String scr1=null;
	ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		getWindow().setFlags(
				android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,
				android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.viewimage);
		new loadPage().execute();




	}


	private Drawable LoadImageFromWebOperations(String url) {


		// TODO Auto-generated method stub
		try{
			InputStream is = (InputStream) new URL(url).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");
			return d;
		}catch (Exception e) {
			System.out.println("Exc="+e);
			return null;
		}
	}


	public class loadPage extends AsyncTask<String, Integer, Void> {

		private ProgressDialog pdia;

		ImageView s;

		Drawable scr;

		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			pdia = new ProgressDialog(viewimage.this);
			pdia.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pdia.setMessage("Loading Please wait.");
			pdia.requestWindowFeature (Window.FEATURE_NO_TITLE);
			pdia.setIndeterminate(false);
			pdia.setCancelable(false);
			pdia.show();

		}
		@Override
		protected Void doInBackground(String... arg0) {


			String url="http://zagg-blog.s3.amazonaws.com/community/blog/wp-content/uploads/2011/09/5-Android-vs-Apple-%E2%80%93-Battle-of-the-Best.jpg";
			s=(ImageView)findViewById(R.id.i1);
			scr=LoadImageFromWebOperations(url);

			return null;
			// TODO Auto-generated method stub
		}

		@Override
		protected void onPostExecute(Void unused) {
			pdia.dismiss();
			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					s.setImageDrawable(scr);
				}


			});

		}
	}



	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {


			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
