package com.example.activityimplementsrunnable;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends Activity implements Runnable {

	Thread myThread;
	boolean running;
	int cnt;

	TextView myTextView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myTextView = (TextView) findViewById(R.id.text);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		startThread();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		stopThread();
	}

	public void startThread() {
		running = true;
		myThread = new Thread(this);
		myThread.start();
		cnt = 0;
	}

	public void stopThread() {
		running = false;
		boolean retry = true;
		while (retry) {
			try {
				myThread.join();
				retry = false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {

			try {
				cnt++;
				Thread.sleep(100);
				handler.sendMessage(handler.obtainMessage());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			// super.handleMessage(msg);
			myTextView.setText(String.valueOf(cnt));
		}

	};
}