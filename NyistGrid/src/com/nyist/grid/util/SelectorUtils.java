package com.nyist.grid.util;

import com.nyist.grid.global.NyistApp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 25, 20138:31:26 PM
 * @version 
 * @Description: 代码实现Selector效果
 */
public class SelectorUtils {

	/**
	 * 设置背景图片 如果是ImageView不适用背景图片
	 * @param context
	 * @param view
	 * @param normalName
	 * @param pressedName
	 * @author guang.shu@magic-point.com
	 */
	public static void setViewImage(Context context,View view,String normalName,String pressedName){
		
		Drawable drawable = newSelector(context, normalName, pressedName);
		if (view instanceof ImageView) {
			((ImageView)view).setImageDrawable(drawable);
		}else{
			view.setBackgroundDrawable(drawable);
		}
	}
	
	/**
	 * new Selector
	 * @param context
	 * @param normalName
	 * @param pressedName
	 * @author guang.shu@magic-point.com
	 * @return
	 */
	public static StateListDrawable newSelector(Context context, String normalName, String pressedName) {  
		StateListDrawable bg = new StateListDrawable();  
		Drawable normal = getDrawableByName(normalName);  
		Drawable pressed =getDrawableByName(pressedName);
		
		bg.addState(new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled }, pressed);  
		bg.addState(new int[] { android.R.attr.state_enabled }, normal);  
		bg.addState(new int[] {}, normal);  
		return bg;  
	} 
	
	/**
	 * new Selectors
	 * @param normalName
	 * @param pressedName
	 * @author guang.shu@magic-point.com
	 * @return
	 */
	public StateListDrawable newSelector(String normalName, String pressedName) {  
		StateListDrawable bg = new StateListDrawable();  
		Drawable normal = getDrawableByName(normalName);  
		Drawable pressed =getDrawableByName(pressedName);
		
		bg.addState(new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled }, pressed);  
		bg.addState(new int[] { android.R.attr.state_enabled }, normal);  
		bg.addState(new int[] {}, normal);  
		return bg;  
	}
	
	
	/**
	 * @param context
	 * @param idNormal
	 * @param idPressed
	 * @param idFocused
	 * @param idUnable
	 * @return
	 * @author guang.shu@magic-point.com
	 */
	public static StateListDrawable newSelector(Context context, int idNormal, int idPressed, int idFocused,  
            int idUnable) {  
	    StateListDrawable bg = new StateListDrawable();  
	    Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);  
	    Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);  
	    Drawable focused = idFocused == -1 ? null : context.getResources().getDrawable(idFocused);  
	    Drawable unable = idUnable == -1 ? null : context.getResources().getDrawable(idUnable);  
	    // View.PRESSED_ENABLED_STATE_SET  
	    bg.addState(new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled }, pressed);  
	    // View.ENABLED_FOCUSED_STATE_SET  
	    bg.addState(new int[] { android.R.attr.state_enabled, android.R.attr.state_focused }, focused);  
	    // View.ENABLED_STATE_SET  
	    bg.addState(new int[] { android.R.attr.state_enabled }, normal);  
	    // View.FOCUSED_STATE_SET  
	    bg.addState(new int[] { android.R.attr.state_focused }, focused);  
	    // View.WINDOW_FOCUSED_STATE_SET  
	    bg.addState(new int[] { android.R.attr.state_window_focused }, unable);  
	    // View.EMPTY_STATE_SET  
	    bg.addState(new int[] {}, normal);  
	    return bg;  
	}
	
	/**
	 * 设置背景颜色
	 * @param view
	 * @param normalName
	 * @param pressedName
	 * @author guang.shu@magic-point.com
	 */
	public static void setViewBackGround(View view,String normalName,String pressedName){
		
		Drawable drawable = newSelector(NyistApp.getApp(), normalName, pressedName);
		view.setBackgroundDrawable(drawable);
	}
	
	private static Drawable getDrawableByName(String source){
		String sourceName=NyistApp.getApp().getPackageName()+":drawable/"+source;
		Drawable drawable = null;
		int resId=NyistApp.getApp().getResources().getIdentifier(sourceName,null,null);
		if (resId!=0){
			drawable=NyistApp.getApp().getResources().getDrawable(resId);
		}
		return drawable;
	}
}
