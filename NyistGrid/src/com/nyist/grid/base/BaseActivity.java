package com.nyist.grid.base;

import java.util.HashMap;
import java.util.List;

import com.nyist.grid.R;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.entity.TaskEntity;
import com.nyist.grid.global.NyistApp;
import com.nyist.grid.util.common.LogFactory;
import com.nyist.grid.view.TitleBar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * 所有类的基类
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201311:03:55 AM
 * @version
 */
public abstract class BaseActivity extends Activity {
	protected Context mContext;// 上下文
	protected NyistApp mGlobal = NyistApp.getApp();// 全局Application对象
	protected TitleBar mTitleBar;
	protected LinearLayout mBaseLayout;
	private View progressBar;// /显示加载进度的View

	public static BaseActivity currentBaseActivity;// 当前的act
	protected String mActivityName;// /当前Activity的名称
	/** 加载数据是否成功，默认为true */
	protected boolean isSuccess = true; // 此处声明，默认值不能修改，如需要请在代码中动态修改

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		if (needObserver()) {
			mGlobal.addActivity(this);
		}
		
		initBaseData();
		installViews();
		initTitleBar();
		registerEvents();
		hideProgress();
	}

	@Override
	public void setContentView(int layoutResID) {
		LayoutInflater inflater = LayoutInflater.from(BaseActivity.this);
		inflater.inflate(layoutResID, mBaseLayout);
	}

	@Override
	public void setContentView(View view) {
		mBaseLayout.addView(view);
	}

	/**
	 * @Title: initTitleBar
	 * @Description: 初始化TitleBar
	 * @returnType void
	 */
	protected void initTitleBar() {
		// 设置左边的按钮的事件
		if (null != mTitleBar && null != mTitleBar.leftBtn) {
			mTitleBar.leftBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					finish();
				}
			});

		}
	}

	private void initBaseData() {
		mContext = this;
		mActivityName = this.getClass().getSimpleName();
		super.setContentView(R.layout.base_activity);
		mTitleBar = (TitleBar) this.findViewById(R.id.titlebar);
		mBaseLayout = (LinearLayout) this.findViewById(R.id.content);
		progressBar = this.findViewById(R.id.show_request_progress_bar);
	}

	/**
	 * 加载布局文件，初始化对应的view对象。
	 */
	protected abstract void installViews();

	/**
	 * Activity中所有View的绑定事件，都放置到该类中。
	 */
	protected abstract void registerEvents();

	/**
	 * 显示进度条对话框
	 */
	private void showProgress() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				progressBar.setVisibility(View.VISIBLE);
			}
		});
	}

	/**
	 * 隐藏进度条对话框
	 */
	private void hideProgress() {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				progressBar.setVisibility(View.INVISIBLE);
			}
		});
	}

	protected boolean needObserver() {
		return true;
	}

	// 封装日志
	/**
	 * debug的日志，tag为类名
	 * 
	 * @author guang.shu@magic-point.com
	 * @version 创建时间：2013-2-20 下午3:42:37
	 * @param content
	 */
	public void dLog(String content) {
		LogFactory.d(this.getClass().getSimpleName(), content);
	}

	/**
	 * error的日志，tag为类名
	 * 
	 * @author guang.shu@magic-point.com
	 * @version 创建时间：2013-2-20 下午3:42:37
	 * @param content
	 */
	public void dError(String content) {
		LogFactory.e(this.getClass().getSimpleName(), content);
	}

	/**
	 * 界面数据请求到数据后，刷新界面的数据。
	 * 
	 * @param param
	 */
	public abstract void refresh(Object... param);

	@SuppressWarnings("null")
	public void refreshWithException(Object... param) {
		try {
			boolean isRight = true;
			if (null == param && param[1] == null) {
				isRight = false;
			}
			if (isRight) {
				this.refresh(param);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 添加新的任务
	 * 
	 * @param taskID
	 * @param pageID
	 * @param taskParam
	 */
	public void addNewTask(int taskID, int pageID,
			HashMap<String, Object> taskParam) {
		TaskEntity taskEntity = new TaskEntity(taskID, pageID, taskParam);
		mGlobal.addPageIdMap(pageID, mActivityName);
		mGlobal.addTask(taskEntity);
	}
}
