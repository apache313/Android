package vn.hanoidev.entity;

import vn.hanoidev.widgets.R;

public class Widget {
	private String name = "";
	private int icon = R.drawable.ic_widget;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public Widget(String name, int icon) {
		this.name = name;
		this.icon = icon;
	}
}
