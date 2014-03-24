package com.nyist.grid.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 29, 20134:46:22 PM
 * @version 
 * @Description: 网络物理连接状态管理类
 */
public class ConnectUtil {
	private static final String TAG = ConnectUtil.class.getSimpleName();
	
	/**
	 * @Title: isNetworkAvailable
	 * @Description: 网络是否可用
	 * @param @param context
	 * @param @return
	 * @return boolean
	 */
	public static boolean isNetworkAvailable(Context context) {
		System.out.println(TAG+"[Begin]");
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] info = cm.getAllNetworkInfo();
		if (info != null) {
			for (int i = 0; i < info.length; i++) {
				if (info[i].getState() == NetworkInfo.State.CONNECTED) {
					System.out.println(TAG+"[End]");
					return true;
				} else {
					continue;
				}
			}
		}
		System.out.println(TAG+"[End]");
		return false;
	}

	public static boolean isAvailable(Context context){
		ConnectivityManager cManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cManager.getActiveNetworkInfo();
		return info != null && info.isAvailable();
	}

	public static boolean isWifi(Context context){
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if(info != null){
			if(info.isConnectedOrConnecting()){
				return info.getTypeName().equalsIgnoreCase("WIFI");
			}
		}
		return false;
	}

	public static boolean isMobile(Context context){
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if(info != null){
			if(info.isConnectedOrConnecting()){
				return info.getTypeName().equalsIgnoreCase("MOBILE");
			}
		}
		return false;
	}
}
