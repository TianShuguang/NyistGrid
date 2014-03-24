package com.nyist.grid.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;

import com.nyist.grid.R;
import com.nyist.grid.adapter.NoticeAdapter;
import com.nyist.grid.base.BaseActivity;
import com.nyist.grid.base.constant.PageIdConstant;
import com.nyist.grid.base.constant.TaskType;
import com.nyist.grid.base.constant.WebConstant;
import com.nyist.grid.entity.NoticeEntity;
import com.nyist.grid.entity.outpacket.OutPacketNoticeEntity;
import com.nyist.grid.global.GlobalConstant;
import com.nyist.grid.util.common.LogFactory;
import com.nyist.grid.view.MyListView;
import com.nyist.grid.view.TitleBar;

public class Main_NoticeActivity extends BaseActivity{
	private static final String TAG="Main_NoticeActivity";
	private MyListView listView;
	private NoticeAdapter adapter;
	protected List<NoticeEntity> noticeList=new ArrayList<NoticeEntity>();
	
	@Override
	protected void installViews() {
		setContentView(R.layout.notice_list_view);
		listView=(MyListView) this.findViewById(R.id.lvNotice);
		adapter=new NoticeAdapter(noticeList);
		listView.setAdapter(adapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		LogFactory.e(TAG, "onResume()----------------");
		doRequestNotice();
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

	@SuppressWarnings("unchecked")
	@Override
	public void refresh(Object... param) {
		int pageId = (Integer) param[0];
		
		switch (pageId) {
		case PageIdConstant.TYPE_NOTICE:
			noticeList=(List<NoticeEntity>) param[1];
			LogFactory.e(TAG, "refresh(Object... param)   noticeList  "+noticeList);
			adapter.notifyDataSetChanged(noticeList);
			break;

		default:
			break;
		}
		
	}

	@Override
	protected void initTitleBar() {
		super.initTitleBar();
		mTitleBar.changeStyle(TitleBar.STYLE.TWO_BTN_AND_TITLE);
		mTitleBar.leftBtn.setVisibility(View.VISIBLE);
		mTitleBar.rightBtn.setVisibility(View.VISIBLE);
		mTitleBar.centerTextView
				.setText("公告中心");
	}
	
	private void doRequestNotice() {
		OutPacketNoticeEntity outpacket=new OutPacketNoticeEntity(
				WebConstant.NAMESPACE, WebConstant.GETNOTICE_METHOD_NAME,
				WebConstant.PUBLIC_WEBSERVICE_URL, WebConstant.GETNOTICE_SOAP_ACTION);
		HashMap<String, Object> taskParam = new HashMap<String, Object>();
		taskParam.put(GlobalConstant.MODEL_KEY, outpacket);
		addNewTask(TaskType.TYPE_NOTICE, 
				PageIdConstant.TYPE_NOTICE, 
				taskParam);
	}

}
