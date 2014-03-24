package com.nyist.grid.entity;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 25, 201310:27:23 PM
 * @version 
 * @九宫格的域对象
 */
public class GridRowEntity {
	private String id;
	private String title;
	private String normalBgName;
	private String pressedBgName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNormalBgName() {
		return normalBgName;
	}
	public void setNormalBgName(String normalBgName) {
		this.normalBgName = normalBgName;
	}
	public String getPressedBgName() {
		return pressedBgName;
	}
	public void setPressedBgName(String pressedBgName) {
		this.pressedBgName = pressedBgName;
	}
	
	
}
