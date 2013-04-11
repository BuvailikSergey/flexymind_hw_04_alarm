package com.flexymind.alarm;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TimePicker timePicker;
	
	public AlarmBroadcastReceiver alarm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		timePicker = (TimePicker) findViewById(R.id.timePicker);
		
		alarm = new AlarmBroadcastReceiver();
	}

	public void newAlarm(View view) {
		if(alarm != null) {
			alarm.setNewAlarm(this, mGetTime());
		}
		else {
			Toast.makeText(this, "Alarm is null", Toast.LENGTH_SHORT).show();
		}
	}
	
	private long mGetTime() {
		Calendar alarmTime = Calendar.getInstance();
		if (alarmTime.get(Calendar.HOUR_OF_DAY) > timePicker.getCurrentHour()) 
			alarmTime.set(Calendar.DAY_OF_MONTH, (alarmTime.get(Calendar.DAY_OF_MONTH) + 1));
		
		alarmTime.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
		alarmTime.set(Calendar.MINUTE, timePicker.getCurrentMinute());
		return alarmTime.getTimeInMillis();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
