package com.nyist.grid.global;

import java.util.ArrayList;
import java.util.HashMap;

import com.nyist.grid.base.BaseActivity;
import com.nyist.grid.entity.TaskEntity;
import com.nyist.grid.util.common.LogFactory;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;

/**
 * @author guang.shu@magic-point.com
 * @Description: 全局控制类，伴随应用程序的整个生命周期
 * @date Mar 21, 201310:41:48 PM
 * @version
 */
public class NyistApp extends Application {
	private static final String TAG="NyistApp";
	private static NyistApp appInstance;
	private ArrayList<TaskEntity> mTaskList;// 任务列表
	public HashMap<Integer, String> mPageIdMap ;// key:PageId  value: ActivityName
	private ArrayList<BaseActivity> mBaseActivityList;// 当前未关闭的界面列表
	/**
	 * 获得Application对象
	 * @return
	 */
	public static NyistApp getApp() {
		return appInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		appInstance = this;
		mTaskList = new ArrayList<TaskEntity>();
		mPageIdMap = new HashMap<Integer, String>();
		mBaseActivityList=new ArrayList<BaseActivity>();
		
		if (!AppService.isRunning) {
			Intent it = new Intent(this, AppService.class);
			this.startService(it);
			AppService.isRunning = true;
		}
	}
	/**
	 * 屏幕方向改变或一些系统设置改变比如打开或者隐藏键盘时触发
	 * 在改变屏幕方向、弹出软件盘和隐藏软键盘时，不再去执行onCreate()方法，而是直接执行onConfigurationChanged()。
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	/**
	 * 当设备内存低时该事件被触发。当内存低或不足以运行一个应用时，在OnLowMemory() 事件处理器中从堆中释放不用的内存。
	 */
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	// ==============Task的管理=====Begin======================
	/**
	 * 添加新的任务
	 * 
	 * @param newTask
	 */
	public void addTask(TaskEntity newtask) {
		synchronized (mTaskList) {
			mTaskList.add(newtask);
		}
	}
	/**
	 * 移除任务
	 * 
	 * @param newTask
	 */
	public void removeTask(TaskEntity task){
		synchronized (mTaskList) {
			mTaskList.remove(task);
		}
	}
	/**
	 * 获得当前的任务列表
	 * @return
	 */
	public ArrayList<TaskEntity> getTaskList() {
		synchronized (mTaskList) {
			return mTaskList;
		}
	}
	// ==============Task的管理=====End=======================
	
	/**
	 * 添加PageId和ActivityName之间的映射
	 * @param pageId    
	 * @param activityName
	 */
	public void addPageIdMap(Integer pageId,String activityName){
		mPageIdMap.put(pageId, activityName);
	}
	
	//==============Activity的管理==================================
	/**
	 * 添加AbsBaseActivity
	 * 
	 * @param ac
	 */
	public void addActivity(BaseActivity ac) {
		if (!mBaseActivityList.contains(ac)) {
			mBaseActivityList.add(ac);
		}
	}
	
	/**
	 * 从列表中删除指定的AbsBaseActivity
	 * 
	 * @param ac
	 */
	public void removeActivity(BaseActivity ac) {
		mBaseActivityList.remove(ac);
	}
	
	/**
	 * 删除所有的AbsBaseActivity
	 */
	public void removeAllAbsBaseActivity() {
		mBaseActivityList.clear();
	}
	/**
	 * 根据Activity的名称去查找当前Activity的实例
	 * @param activityName
	 * @return
	 */
	public BaseActivity getActivityByName(String activityName) {
		for (BaseActivity activity : mBaseActivityList) {
			LogFactory.d(TAG, "activity.getClass().getSimpleName()"+activity.getClass().getSimpleName());
			if (activity.getClass().getSimpleName().equals(activityName)) {
				return activity;
			}
		}
		return null;
	}
}
