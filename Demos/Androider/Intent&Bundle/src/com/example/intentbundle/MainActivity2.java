package com.example.intentbundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends Activity {

	private Button backButton;
	Button cancel2Button;
	TextView nameField;
	TextView phonenumberField;
	TextView emailField;
	TextView websiteField;
	TextView addressField;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startLayout2();

		Bundle bundle = this.getIntent().getExtras();
		CharSequence textName_value = bundle.getCharSequence("bName");
		nameField = (TextView) findViewById(R.id.name);
		nameField.setText("Hello " + textName_value);

		CharSequence textPhonenumberIs_value = bundle
				.getCharSequence("bPhonenumber");
		phonenumberField = (TextView) findViewById(R.id.phonenumber);
		phonenumberField.setText("Phone Number: " + textPhonenumberIs_value);

		CharSequence textEmailIs_value = bundle.getCharSequence("bEmail");
		emailField = (TextView) findViewById(R.id.email);
		emailField.setText("Email: " + textEmailIs_value);

		CharSequence textWebsiteIs_value = bundle.getCharSequence("bWebsite");
		websiteField = (TextView) findViewById(R.id.website);
		websiteField.setText("Website: " + textWebsiteIs_value);

		CharSequence textAddressIs_value = bundle.getCharSequence("bAddress");
		addressField = (TextView) findViewById(R.id.address);
		addressField.setText("Address: " + textAddressIs_value);
	};

	private Button.OnClickListener backOnClickListener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity2.this, MainActivity.class);

			startActivity(intent);
			finish();
		}
	};

	private Button.OnClickListener cancelOnClickListener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			finish();
		}
	};

	private void startLayout2() {
		setContentView(R.layout.activity_main2);
		backButton = (Button) findViewById(R.id.back);
		backButton.setOnClickListener(backOnClickListener);
		cancel2Button = (Button) findViewById(R.id.cancel_2);
		cancel2Button.setOnClickListener(cancelOnClickListener);
	};
}
