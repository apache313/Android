package com.example.imageview_custom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView msg;
	TouchView touchView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		msg = (TextView) findViewById(R.id.msg);
		touchView = (TouchView) findViewById(R.id.touchview);

	}



	public void updateMsg(String string, int color) {
		Log.i("hehe", string);
		msg.setTextColor(color);
		msg.setText(string);
	}

}