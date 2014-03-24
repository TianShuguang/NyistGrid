package com.nyist.grid.base.constant;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 29, 20135:20:45 PM
 * @version
 * @Description: UI界面请求数据，调用指定的任务 
 */
public interface TaskType {
	/* 登录*/
	public static final int TYPE_USER_LOGIN=1;
	/* 公告*/
	public static final int TYPE_NOTICE=11;
	
	/* 消息日志*/
	/** 日志 **/
	public static final int TYPE_MESSAGE_MY=2;
	/** 群消息**/
	public static final int TYPE_MESSAGE_TEACHER=3;
	/* 课题中心*/
	/** 我的课题 **/
	public static final int TYPE_TOPIC_MY=4;
	/** 所有课题 **/
	public static final int TYPE_TOPIC_ALL=5;
	/** 搜索课题 **/
	public static final int TYPE_TOPIC_SEARCH=6;
	/* 个人中心*/
	/** 我的进度 **/
	public static final int TYPE_MY_SCHEDUAL=7;
	/** 我的资料 **/
	public static final int TYPE_MY_DETAIL=8;
	/** 导师资料**/
	public static final int TYPE_MY_TEACHER=9;

}
