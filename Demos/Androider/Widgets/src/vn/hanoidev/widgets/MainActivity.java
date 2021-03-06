package vn.hanoidev.widgets;

import vn.hanoidev.adapters.WidgetAdapter;
import vn.hanoidev.entity.Widget;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView mListView;
	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTitle("Danh sách các Widgets");
		drawListWidget();

	}

	private void drawListWidget() {
		final Widget aWidget[] = new Widget[] {
				new Widget("TextView", R.drawable.ic_widget),
				new Widget("EditText", R.drawable.ic_widget) };

		WidgetAdapter adapter = new WidgetAdapter(this,
				R.layout.listview_widget, aWidget);

		mListView = (ListView) findViewById(R.id.lvWidget);
		mListView.setAdapter(adapter);

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Widget widget = (Widget) mListView.getItemAtPosition(position);

				String className = getApplicationContext().getPackageName()
						+ "." + widget.getName() + "Activity";
				Class<?> clazz = null;
				try {
					clazz = Class.forName(className);
				} catch (ClassNotFoundException e) {
					Log.i(TAG, "Không tạo được class từ String " + className);
				}
				Intent myIntent = new Intent(getApplicationContext(), clazz);
				startActivity(myIntent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_list, menu);
		return true;
	}

}
