package com.example.notificationwithservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button buttonStartService = (Button) findViewById(R.id.startservice);
		Button buttonStopService = (Button) findViewById(R.id.stopservice);

		buttonStartService.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						NotifyService.class);
				MainActivity.this.startService(intent);
			}
		});

		buttonStopService.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(NotifyService.ACTION);
				intent.putExtra("RQS", NotifyService.RQS_STOP_SERVICE);
				sendBroadcast(intent);
			}
		});

	}
}
