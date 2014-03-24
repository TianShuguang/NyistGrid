package com.nyist.grid.activity;

import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.nyist.grid.R;
import com.nyist.grid.base.BaseActivity;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.view.TitleBar;

/**
 * 关于界面
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201310:58:55 AM
 * @version 
 */
public class Main_AboutActivity extends BaseActivity{
	private ImageView imgFirst;
	private TextView tvFirst;
	private ImageView imgSecond;
	private TextView tvSecond;
	
	@Override
	protected void installViews() {
		setContentView(R.layout.main_about_activity);

		imgFirst = (ImageView) findViewById(R.id.imgFirst);
		tvFirst = (TextView) findViewById(R.id.tvFirst);
		imgSecond = (ImageView) findViewById(R.id.imgSecond);
		tvSecond = (TextView) findViewById(R.id.tvSecond);
		
		fillFiledsDomainView();
	}

	private void fillFiledsDomainView() {
		imgFirst.setImageResource(R.drawable.about_nyist_logo);
		tvFirst.setText("\t南阳理工学院软件学院是理工学院重点建设的一个系级学院，是信息产业部、教育部确定的79个“国家计算机应用与软件技术专业领域技能型紧缺人才培养基地”之一，也是河南省首批设立的“八所示范性软件学院”之一，04年被微软（中国）公司评为“优秀合作伙伴”并被命名为全国七所“示范性合作院校”之一。");
		imgSecond.setImageResource(R.drawable.about_stumana);
		tvSecond.setText("\t\t\t设计人员：王豫峰\n\t\t\t开发人员\n\t\t\t\tWEB端：王豫峰\n\t\t\t\tWindowsPhone7端：王宁\n\t\t\t\tWindows8端：王浩，徐晓升\n\t\t\t\tAndroid端：田曙光，刘一鸣\n\t\t\t\tIOS端：高峰端\n\t\t\t\t美工人员：王晓丹，徐鹏俊");
	}

	@Override
	protected void registerEvents() {
		mTitleBar.leftBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}

	@Override
	public void refresh(Object... param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initTitleBar() {
		super.initTitleBar();
		mTitleBar.changeStyle(TitleBar.STYLE.TWO_BTN_AND_TITLE);
		mTitleBar.leftBtn.setVisibility(View.VISIBLE);
		mTitleBar.rightBtn.setVisibility(View.INVISIBLE);
		mTitleBar.centerTextView.setText("关于我们");
	}

}
