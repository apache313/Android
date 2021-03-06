package vn.hanoidev.adapters;

import vn.hanoidev.entity.Widget;
import vn.hanoidev.widgets.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WidgetAdapter extends ArrayAdapter<Widget> {
	Context context;
	int layoutResourceId;
	Widget aWidget[];

	static class WidgetHolder {
		TextView tvName;
		ImageView ivIcon;
	}

	public WidgetAdapter(Context context, int layoutResourceId, Widget[] aWidget) {
		super(context, layoutResourceId, aWidget);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.aWidget = aWidget;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		WidgetHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new WidgetHolder();
			holder.tvName = (TextView) row.findViewById(R.id.tvWidgetName);
			holder.ivIcon = (ImageView) row.findViewById(R.id.ivWidgetIcon);
			row.setTag(holder);
		} else {
			holder = (WidgetHolder) row.getTag();
		}

		Widget widget = aWidget[position];
		holder.tvName.setText(widget.getName());
		holder.ivIcon.setImageResource(widget.getIcon());
		return row;
	}
}
