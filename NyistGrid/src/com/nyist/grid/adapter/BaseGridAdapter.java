package com.nyist.grid.adapter;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nyist.grid.R;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.global.NyistApp;
import com.nyist.grid.util.ValueUtil;
import com.nyist.grid.util.ViewUtil;

/**
 * 九宫格基类的适配器
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 26, 20133:14:09 PM
 * @version
 */

public class BaseGridAdapter extends BaseAdapter {

	public static final String TAG = "BaseGridAdapter";
	private DisplayMetrics localDisplayMetrics = NyistApp.getApp()
			.getResources().getDisplayMetrics();;
	protected List<GridRowEntity> dataList;

	public BaseGridAdapter(List<GridRowEntity> dataList) {
		if (ValueUtil.isNotEmpty(dataList)) {
			this.dataList = dataList;
		} else {
			this.dataList = new ArrayList<GridRowEntity>();
		}
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = ViewUtil.buildView(R.layout.base_grid_activity_item);
		TextView textView = (TextView) convertView
				.findViewById(R.id.activity_name);
		setData(position, textView, dataList);
		convertView
				.setMinimumHeight((int) (96.0F * localDisplayMetrics.density));
		convertView
				.setMinimumWidth(((-12 + localDisplayMetrics.widthPixels) / 3));
		return convertView;
	}

	public void setData(int position, TextView textView,List<GridRowEntity> dataList) {
		int datasize=dataList.size();
		switch (position) {
		case 0:
			ValueUtil.setGridValues(position, textView, dataList);
			break;
		case 1:
			if (1>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
			
		case 2:
			if (2>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		case 3:
			if (3>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		case 4:
			if (4>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		case 5:
			if (5>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		case 6:
			if (6>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		case 7:
			if (7>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		case 8:
			if (8>datasize) {
				break;
			}else {
				ValueUtil.setGridValues(position, textView, dataList);
				break;
			}
		}
	}

}
