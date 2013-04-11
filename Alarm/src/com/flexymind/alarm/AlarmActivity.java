package com.flexymind.alarm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class AlarmActivity extends Activity {

	MediaPlayer mp;
	public AlarmBroadcastReceiver alarm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		
		alarm = new AlarmBroadcastReceiver();
		mp = MediaPlayer.create(this, R.raw.yeah);
		
		mp.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}
	
	public void delayAlarm(View view) {
		alarm.setNewAlarm(this, System.currentTimeMillis() + 300000); // отложить будильник на 5 минут
		mp.reset();
		mp.release();
		finish();
	}

	public void cancelAlarm(View view) {
		mp.reset();
		mp.release();
		finish();
	}
	
}
