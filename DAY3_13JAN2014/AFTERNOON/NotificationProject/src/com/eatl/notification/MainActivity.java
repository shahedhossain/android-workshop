package com.eatl.notification;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	SimpleDateFormat sdf;
	Calendar cal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 

		final Context k1=MainActivity.this;

		//		final RemoteViews remoteViews;


		cal = Calendar.getInstance();
		cal.getTime();
		sdf = new SimpleDateFormat("HH:mm");


		Button NotificationBtn = (Button)findViewById(R.id.buttonNotification);

		NotificationBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub



				RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.customnotification);

				NotificationCompat.Builder builder = new NotificationCompat.Builder(k1.getApplicationContext())
				.setSmallIcon(R.drawable.ic_launcher)

				.setTicker("This is ticker")

				.setAutoCancel(true)

				.setContent(remoteViews);


				remoteViews.setImageViewResource(R.id.imagenotileft,R.drawable.ic_launcher);
				remoteViews.setTextViewText(R.id.imagenotiright,sdf.format(cal.getTime()));


				remoteViews.setTextViewText(R.id.title,"Content Title");
				remoteViews.setTextViewText(R.id.text,"Notification Content");



				NotificationManager notificationmanager = (NotificationManager)k1.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

				notificationmanager.notify(0, builder.build());



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
