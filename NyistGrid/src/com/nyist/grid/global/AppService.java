package com.nyist.grid.global;

import java.util.HashMap;

import org.ksoap2.serialization.SoapObject;

import com.nyist.grid.base.BaseActivity;
import com.nyist.grid.base.constant.TaskType;
import com.nyist.grid.base.constant.WebConstant;
import com.nyist.grid.entity.TaskEntity;
import com.nyist.grid.entity.outpacket.OutPacketNoticeEntity;
import com.nyist.grid.exception.NoNetException;
import com.nyist.grid.helper.SoapDataSetHelper;
import com.nyist.grid.soaputil.SoapWebServiceUtil;
import com.nyist.grid.util.ConnectUtil;
import com.nyist.grid.util.common.LogFactory;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Message;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 29, 20132:47:08 PM
 * @version
 */
public class AppService extends Service implements Runnable {
	private static final String TAG = "AppService";
	private Message message = new Message();
	public static boolean isRunning = false;
	/**
	 * 创建更新UI的广播接收器
	 * 
	 * @Fields updateUI : 接收到广播后，执行updateUI方法。
	 */
	private BroadcastReceiver updateUIReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(GlobalConstant.UPDATE_UI_ACTION)) {
				updateUI(message);
			}
		}
	};

	// =========================注册广播==================================================
	/**
	 * 注册更新UI的广播
	 */
	private void registerUpdateUIBroadcast() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(GlobalConstant.UPDATE_UI_ACTION);
		registerReceiver(updateUIReceiver, filter);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		// 注册更新UI的广播
		registerUpdateUIBroadcast();
		Thread t = new Thread(this);
		t.start();
		isRunning = true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		isRunning = false;
	}

	@Override
	public void run() {
		System.out.println(TAG + "service has run....");
		while (isRunning) {
			try {
				if (NyistApp.getApp().getTaskList().size() > 0) {
					System.out.println("NyistApp.getApp().getTaskList().size()"
							+ NyistApp.getApp().getTaskList().size());
					doTask(NyistApp.getApp().getTaskList().get(0));
				} else {
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			} catch (Exception e) {
				LogFactory.d(TAG, "Error" + e.toString());
			}
		}
	}

	/**
	 * 执行任务
	 * 
	 * @param task
	 */
	private void doTask(TaskEntity task) {
		LogFactory.d(
				TAG,
				"AppService.doTask() -> " + "taskType: "
						+ task.getTaskID() + " pageId: "
						+ task.getPageID());
		boolean isNetworkAvailable = ConnectUtil
				.isNetworkAvailable(getApplication());

		HashMap<String, Object> taskParam = task.getTaskParam();

		message.what = task.getPageID();
		LogFactory.d(TAG, "message.what"+message.what);
		message.obj = null;
		try {
			if (isNetworkAvailable == false) {
				throw new NoNetException();
			}
			switch (task.getTaskID()) {
			case TaskType.TYPE_USER_LOGIN:// 登录

				break;
			case TaskType.TYPE_NOTICE:// 公告
				OutPacketNoticeEntity outpacket = (OutPacketNoticeEntity) taskParam
						.get(GlobalConstant.MODEL_KEY);
				LogFactory.i(TAG, outpacket.getNamespace());
				LogFactory.i(TAG, outpacket.getMethodname());
				LogFactory.i(TAG, outpacket.getWebserviceUrl());
				LogFactory.i(TAG, outpacket.getSoapaction());
				SoapObject dataset = SoapWebServiceUtil.GetSoapWebServiceData(
						outpacket.getNamespace(),
						outpacket.getMethodname(),
						outpacket.getWebserviceUrl(),
						outpacket.getSoapaction());
				message.obj = SoapDataSetHelper.GetAllNotice(dataset);
				LogFactory.i(TAG, message.obj.toString());
				outpacket=null;
				break;
			case TaskType.TYPE_MESSAGE_MY:// 日志

				break;
			case TaskType.TYPE_MESSAGE_TEACHER:// 群消息

				break;
			case TaskType.TYPE_TOPIC_MY:// 我的课题

				break;
			case TaskType.TYPE_TOPIC_ALL:// 所有课题

				break;
			case TaskType.TYPE_TOPIC_SEARCH:// 搜索课题

				break;
			case TaskType.TYPE_MY_DETAIL:// 我的资料

				break;
			case TaskType.TYPE_MY_TEACHER:// 导师资料

				break;
			case TaskType.TYPE_MY_SCHEDUAL:// 我的进度

				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			NyistApp.getApp().removeTask(task);
			// 发送广播通知UI更新
			sendBroadcast(new Intent()
					.setAction(GlobalConstant.UPDATE_UI_ACTION));
		}

	}

	// =========================更新UI==================================================

	public void updateUI(Message msg) {
		updateActivityByPageId(msg, msg.what);
	}

	/**
	 * 根据PageId去区分不同的界面。
	 * 
	 * @param msg
	 * @param pageId
	 */
	private void updateActivityByPageId(Message msg, Integer pageId) {

		String activityName = NyistApp.getApp().mPageIdMap.get(pageId);
		LogFactory.d(TAG, "activityName"+activityName);
		BaseActivity activity = NyistApp.getApp().getActivityByName(
				activityName);
		LogFactory.d(TAG, "activity"+activity);
		if (activity != null) {
			activity.refreshWithException(msg.what, msg.obj);
		} else {
			LogFactory.d(TAG, "BaseActivity.currentBaseActivity"+BaseActivity.currentBaseActivity.toString());
			// 直接更新当前界面
			BaseActivity.currentBaseActivity.refreshWithException(msg.what,
					msg.obj);
			// LogFactory.d(TAG, "pageId=" + pageId + ":界面无效，无需更新...");
		}
	}


}
