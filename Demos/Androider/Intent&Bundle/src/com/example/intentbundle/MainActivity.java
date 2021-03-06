package com.example.intentbundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button okButton;
	Button cancel1Button;
	EditText textName;
	EditText textPhonenumberIs;
	EditText textEmailIs;
	EditText textWebsiteIs;
	EditText textAddressIs;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startLayout1();
	}

	private Button.OnClickListener okOnClickListener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			textName = (EditText) findViewById(R.id.whoareyou);
			CharSequence textName_value = textName.getText();

			textPhonenumberIs = (EditText) findViewById(R.id.phonenumberIs);
			CharSequence textPhonenumberIs_value = textPhonenumberIs.getText();

			textEmailIs = (EditText) findViewById(R.id.emailIs);
			CharSequence textEmailIs_value = textEmailIs.getText();

			textWebsiteIs = (EditText) findViewById(R.id.websiteIs);
			CharSequence textWebsiteIs_value = textWebsiteIs.getText();

			textAddressIs = (EditText) findViewById(R.id.addressIs);
			CharSequence textAddressIs_value = textAddressIs.getText();

			Intent intent = new Intent();
			intent.setClass(MainActivity.this, MainActivity2.class);

			Bundle bundle = new Bundle();
			bundle.putCharSequence("bName", textName_value);
			bundle.putCharSequence("bPhonenumber", textPhonenumberIs_value);
			bundle.putCharSequence("bEmail", textEmailIs_value);
			bundle.putCharSequence("bWebsite", textWebsiteIs_value);
			bundle.putCharSequence("bAddress", textAddressIs_value);

			intent.putExtras(bundle);

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

	private void startLayout1() {
		setContentView(R.layout.activity_main);
		okButton = (Button) findViewById(R.id.ok);
		okButton.setOnClickListener(okOnClickListener);
		cancel1Button = (Button) findViewById(R.id.cancel_1);
		cancel1Button.setOnClickListener(cancelOnClickListener);
	};

}
