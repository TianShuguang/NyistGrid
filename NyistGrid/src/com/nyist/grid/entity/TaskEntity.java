package com.nyist.grid.entity;

import java.util.HashMap;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 27, 20131:42:50 PM
 * @version 
 * @Description: UI界面请求数据时候使用
 */
public class TaskEntity {
	private int taskID;
	private int pageID;
	private HashMap<String,Object> taskParam;
	private Object dataObject;
	
	public TaskEntity(int taskID, HashMap<String, Object> taskParam) {
		super();
		this.taskID = taskID;
		this.taskParam = taskParam;
	}
	
	public Object getDataObject() {
		return dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	/**
	 * @param taskID
	 * @param pageID
	 * @param taskParam
	 */
	public TaskEntity(int taskID, int pageID, HashMap<String, Object> taskParam) {
		super();
		this.taskID = taskID;
		this.pageID = pageID;
		this.taskParam = taskParam;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getPageID() {
		return pageID;
	}

	public void setPageID(int pageID) {
		this.pageID = pageID;
	}

	public HashMap<String, Object> getTaskParam() {
		return taskParam;
	}

	public void setTaskParam(HashMap<String, Object> taskParam) {
		this.taskParam = taskParam;
	}
	
}
