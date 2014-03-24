package com.nyist.grid.util;

import com.nyist.grid.global.NyistApp;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 26, 201310:24:17 AM
 * @version
 * @视图帮助类 
 */
public class ViewUtil {
	
	private static LayoutInflater inflater;
	/**
	 * 显示吐司内容
	 * 
	 * @author carlos carlosk@163.com
	 * @version 创建时间：2011-8-9 下午6:10:08
	 * @param msg
	 * @param isLongTime
	 */
	public static void showToast(String msg, boolean isLongTime) {
		if (NyistApp.getApp() == null) {
			return;
		}
		int duration = Toast.LENGTH_SHORT;
		if (isLongTime) {
			duration = Toast.LENGTH_LONG;
		}
		Toast.makeText(NyistApp.getApp(), msg, duration).show();
	}
	
	/**
	 * 创建视图
	 * 
	 * @author carlos carlosk@163.com
	 * @version 创建时间：2011-10-8 下午4:39:34
	 * @return
	 */
	public static View buildView(int layout) {
		return getInflater().inflate(layout, null);
	}
	
	/**
	 * @author carlos carlosk@163.com
	 * @version 创建时间：2011-10-8 下午4:40:36
	 * @return
	 */
	private static LayoutInflater getInflater() {
		if (null == inflater) {
			inflater = LayoutInflater.from(NyistApp.getApp());
		}
		return inflater;
	}
}
