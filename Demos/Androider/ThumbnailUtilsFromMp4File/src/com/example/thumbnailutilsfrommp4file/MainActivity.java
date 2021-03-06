package com.example.thumbnailutilsfrommp4file;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore.Video.Thumbnails;
import android.widget.ImageView;

public class MainActivity extends Activity {

	String filePath = "/sdcard/babymaybe.mp4";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView thumbnail_mini = (ImageView) findViewById(R.id.thumbnail_mini);
		ImageView thumbnail_micro = (ImageView) findViewById(R.id.thumbnail_micro);

		Bitmap bmThumbnail;

		// MICRO_KIND: 96 x 96 thumbnail
		bmThumbnail = ThumbnailUtils.createVideoThumbnail(filePath,
				Thumbnails.MICRO_KIND);
		thumbnail_micro.setImageBitmap(bmThumbnail);

		// MINI_KIND: 512 x 384 thumbnail
		bmThumbnail = ThumbnailUtils.createVideoThumbnail(filePath,
				Thumbnails.MINI_KIND);
		thumbnail_mini.setImageBitmap(bmThumbnail);
	}

}
