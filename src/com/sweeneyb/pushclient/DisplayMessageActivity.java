package com.sweeneyb.pushclient;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		doDisplay();

	}

	protected void onResume() {
		super.onResume();
		doDisplay();
	}

	protected void doDisplay() {
		setContentView(R.layout.activity_display_message);
		TextView mDisplay = (TextView) findViewById(R.id.messageText);
		Intent intent = getIntent();
		if (intent != null) {
			if (!intent.getExtras().isEmpty()) {
				String message = intent.getExtras().get("message").toString();
				Log.d(MainActivity.TAG, "displayMessage: "+message);
				mDisplay.setText(message);
			}
		} else {
			mDisplay.setText(R.string.noMessage);
		}
		
		NotificationManager mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(GcmIntentService.NOTIFICATION_ID);

	}
}
