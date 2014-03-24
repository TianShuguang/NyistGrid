package com.nyist.grid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyListView extends ListView{

	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/* (non-Javadoc)
	 * @see android.widget.ListView#onMeasure(int, int)
	 * 解决ScrollerView 和 ListView bug 
	 * 目前存在一个bug 会多次调用getView
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	
	

}
