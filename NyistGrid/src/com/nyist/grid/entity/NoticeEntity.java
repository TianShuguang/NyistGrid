package com.nyist.grid.entity;

/**
 * 公告实体类
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201311:46:44 PM
 * @version 
 */
@SuppressWarnings("serial")
public class NoticeEntity extends BaseEntity{
	String postID;
	String postTitle;
	String postContent;
	String postDate;
	String postPersonName;
	String postContentText;
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getPostPersonName() {
		return postPersonName;
	}
	public void setPostPersonName(String postPersonName) {
		this.postPersonName = postPersonName;
	}
	public String getPostContentText() {
		return postContentText;
	}
	public void setPostContentText(String postContentText) {
		this.postContentText = postContentText;
	}
	
}
