package com.javacodegeeks.android.androidintentexample;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static int MSG_ID = 2;
	private Handler handler;
	final Context context = this;
	private WebView webView;
	private String content;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	
		handler = new Handler() {

			@Override
			public void handleMessage(Message message) {

				if (message.arg1 == MSG_ID) {

					content = (String) message.obj;

					this.post(new Runnable() {

						public void run() {

							
						}

					});

				}
			}
		};

	}

	
	
public void launchbrowser(View view) {
	
	EditText et=(EditText)findViewById(R.id.url);
	String url="http://"+et.getText().toString();
	Intent intentImplicit = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    try { 
          startActivity(intentImplicit);
        } catch (ActivityNotFoundException ex) { 
            ex.printStackTrace();
        }

	}
}