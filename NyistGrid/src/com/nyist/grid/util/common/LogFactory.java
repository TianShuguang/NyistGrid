package com.nyist.grid.util.common;

import android.util.Log;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 29, 20134:54:06 PM
 * @version 
 */
public class LogFactory {
	public static void d(String TAG, String msg){
			Log.d(TAG, msg);
	}

	public static void e(String tag, String msg){
			Log.e(tag, msg);
	}

	public static void v(String tag, String msg){
			Log.v(tag, msg);													
	}
	
	public static void i(String tag, String msg){
		Log.i(tag, msg);													
}
	
}
