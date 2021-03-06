package com.example.thumbnailutils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private final int Thumbnail_WIDTH = 50;
	private final int Thumbnail_HEIGHT = 50;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView thumbnail = (ImageView) findViewById(R.id.thumbnail);

		Bitmap bmSource = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);

		Bitmap bmThumbnail = ThumbnailUtils.extractThumbnail(bmSource,
				Thumbnail_WIDTH, Thumbnail_HEIGHT);

		thumbnail.setImageBitmap(bmThumbnail);
	}

}
