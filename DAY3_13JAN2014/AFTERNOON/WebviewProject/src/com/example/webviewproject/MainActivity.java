package com.example.webviewproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView mWebView = (WebView) findViewById(R.id.web);
		 mWebView.getSettings().setJavaScriptEnabled(true);
		 mWebView.getSettings().setBuiltInZoomControls(true);
		 mWebView.loadUrl("file:///android_asset/med.htm");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
