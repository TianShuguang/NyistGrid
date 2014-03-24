package com.nyist.grid.activity;

import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;

import com.nyist.grid.base.BaseGridActivity;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.helper.GridDataHelper;
import com.nyist.grid.view.TitleBar;

/**
 * 日志九宫格
 * @author guang.shu@magic-point.com
 * @date Mar 28, 201310:53:35 AM
 * @version 
 */
public class Main_MessageActivity extends BaseGridActivity{

	@Override
	protected void registerEvents() {
		super.registerEvents();
		mTitleBar.leftBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	protected void initTitleBar() {
		super.initTitleBar();
		mTitleBar.changeStyle(TitleBar.STYLE.TWO_BTN_AND_TITLE);
		mTitleBar.centerTextView.setText("日志");
		mTitleBar.leftBtn.setVisibility(View.VISIBLE);
		mTitleBar.rightBtn.setVisibility(View.INVISIBLE);
	}

	@Override
	protected List<GridRowEntity> getGridRowDomains() {
		List<GridRowEntity> gridrowdomain=GridDataHelper.getMessageDatas();
		return gridrowdomain;
	}

	@Override
	protected void onClickGridItem(int index) {
		// TODO Auto-generated method stub
		
	}

}
