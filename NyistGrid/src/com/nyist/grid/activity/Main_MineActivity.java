package com.nyist.grid.activity;

import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;

import com.nyist.grid.base.BaseGridActivity;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.helper.GridDataHelper;
import com.nyist.grid.view.TitleBar;

/**
 * 个人中心九宫格
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201310:58:40 AM
 * @version 
 */
public class Main_MineActivity extends BaseGridActivity{
	
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
	protected void initTitleBar() {
		super.initTitleBar();
		mTitleBar.changeStyle(TitleBar.STYLE.TWO_BTN_AND_TITLE);
		mTitleBar.centerTextView.setText("个人中心");
		mTitleBar.leftBtn.setVisibility(View.VISIBLE);
		mTitleBar.rightBtn.setVisibility(View.INVISIBLE);
	}

	@Override
	public void refresh(Object... param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<GridRowEntity> getGridRowDomains() {
		List<GridRowEntity> gridrowdomain=GridDataHelper.getMineDatas();
		return gridrowdomain;
	}

	@Override
	protected void onClickGridItem(int index) {
		switch (index) {
		case 0:
			
			break;

		default:
			break;
		}
		
	}

}
