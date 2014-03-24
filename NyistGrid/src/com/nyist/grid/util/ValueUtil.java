package com.nyist.grid.util;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.global.NyistApp;

/**
 * 所有值操作帮助类
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 25, 20138:23:59 PM
 * @version 
 */
public class ValueUtil {
	public static SelectorUtils selectorUtils=new SelectorUtils();
	
	public static boolean isNotEmpty(Object object) {
		return null != object;
	}
	public static boolean isEmpty(Object object) {
		return null == object;
	}
	
	public static boolean isStrEmpty(String value) {
		if (null == value || "".equals(value.trim())) {
			return true;
		} /*
		 * else { // 判断是否全是全角空格 value = value.replaceAll(" ", "").trim(); if
		 * (null == value || "".equals(value.trim())) { return true; } }
		 */
		return false;
	}
	
	/**
	 * 根据String的资源id,获得字符串
	 * 
	 * @author guang.shu@magic-point.com
	 * @version 创建时间：Mar 25, 20138:23:59 PM
	 * @param pause
	 * @return
	 */
	public static String getString(int resId) {

		return NyistApp.getApp().getString(resId);
	}
	

	
	public static void setGridValues(int position,TextView textView,List<GridRowEntity> datasList){
		textView.setText(datasList.get(position).getTitle());
		Drawable draw = selectorUtils.newSelector(datasList.get(position).getNormalBgName(), datasList.get(position).getPressedBgName());
		draw.setBounds(0, 0, draw.getIntrinsicWidth(),
				draw.getIntrinsicHeight());
		textView.setCompoundDrawables(null, draw, null, null);
		
	}
}
