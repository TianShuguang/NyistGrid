package com.nyist.grid.view;

import com.nyist.grid.R;
import com.nyist.grid.myinterface.MyViewStyle;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 所有界面的TitleBar
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 21, 201310:55:26 PM
 * @version 
 */


public class TitleBar extends RelativeLayout implements MyViewStyle{
	/**
	 * @Description: TitleBar的样式，根据不同的样式去显示
	 * @author guang.shu@magic-point.com
	 * @date Mar 21, 201310:58:54 PM
	 * @version 
	 */
	public interface STYLE{
		int TWO_BTN_AND_TITLE = 1;///2个按钮和一个Title.
		int BACK_BTN_AND_TITLE = 2;// 1个返回按钮和一个Title,主要是返回按钮和一般按钮的显示效果不一样。
	}
	
	private int mStyle = 0;///当前的样式
	private Context mContext;
	private LayoutInflater mInflater;
	private Resources mRes;
	
	public Button leftBtn;//左边的按钮
	public TextView centerTextView;//中间的文本
	public Button rightBtn;//右边的按钮
	
	
	
	public TitleBar(Context context) {
		super(context);
		init(context);
	}
	
	public TitleBar(Context context, int mStyle) {
		super(context);
		this.mStyle = mStyle;
		init(context);
	}
	
	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	private void init(Context context) {
		this.mContext = context;
		mRes = getResources();
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public void changeStyle(int style) {
		getViewByInflater(style);
	}
	
	private void getViewByInflater(int style) {
		switch (style) {
		case STYLE.TWO_BTN_AND_TITLE:{
			///2个按钮和一个Title。
			buildTwoBtnAndTitle_Style();
			break;
		}
		case STYLE.BACK_BTN_AND_TITLE:{
			// 1个返回按钮和一个Title,主要是返回按钮和一般按钮的显示效果不一样。
			break;
		}
		default:
			break;
		}
	}
	
	/**
	 * 构建2个按钮和标题的TitleBar
	 */
	private void buildTwoBtnAndTitle_Style() {
		mInflater.inflate(R.layout.titlebar_two_btn_and_title, this);
		leftBtn = (Button) findViewById(R.id.btn_left);
		rightBtn = (Button) findViewById(R.id.btn_right);
		centerTextView = (TextView) findViewById(R.id.tv_center);
	}

}
