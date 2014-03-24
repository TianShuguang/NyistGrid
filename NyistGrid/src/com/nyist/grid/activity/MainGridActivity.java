package com.nyist.grid.activity;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.nyist.grid.base.BaseGridActivity;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.helper.GridDataHelper;
import com.nyist.grid.view.TitleBar;

/**
 * 首页九宫格
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 26, 201311:05:02 PM
 * @version
 */
public class MainGridActivity extends BaseGridActivity {

	@Override
	protected void initTitleBar() {
		super.initTitleBar();
		mTitleBar.changeStyle(TitleBar.STYLE.TWO_BTN_AND_TITLE);
		mTitleBar.centerTextView.setText("毕业跟踪管理系统");
		mTitleBar.leftBtn.setVisibility(View.INVISIBLE);
		mTitleBar.rightBtn.setVisibility(View.INVISIBLE);
	}

	@Override
	protected List<GridRowEntity> getGridRowDomains() {
		List<GridRowEntity> gridrowdomain = GridDataHelper.getHomeDatas();
		return gridrowdomain;
	}

	@Override
	protected void onClickGridItem(int index) {
		switch (index) {
		case 0:
			Intent noticeIntent=new Intent(MainGridActivity.this, Main_NoticeActivity.class);
			startActivity(noticeIntent);
			break;
		case 1:
			Intent messageIntent=new Intent(MainGridActivity.this, Main_MessageActivity.class);
			startActivity(messageIntent);
			break;
		case 2:
			Intent listIntent=new Intent(MainGridActivity.this, Main_ListActivity.class);
			startActivity(listIntent);
			break;
		case 3:
			Intent mineIntent=new Intent(MainGridActivity.this, Main_MineActivity.class);
			startActivity(mineIntent);
			break;
		case 4:

			break;
		case 5:
			Intent aboutIntent=new Intent(MainGridActivity.this, Main_AboutActivity.class);
			startActivity(aboutIntent);
			break;
		}

	}

}
