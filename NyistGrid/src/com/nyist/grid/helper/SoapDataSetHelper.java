package com.nyist.grid.helper;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.serialization.SoapObject;

import com.nyist.grid.entity.NoticeEntity;

/**
 * Soap返回的DataSet的帮助类，从此类中获得数据
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201311:36:06 PM
 * @version 
 */
public class SoapDataSetHelper {
	public static ArrayList<NoticeEntity> datalist = new ArrayList<NoticeEntity>();
	public static NoticeEntity noticeEntity;
	//获得公告信息
	public static ArrayList<NoticeEntity> GetAllNotice(SoapObject dataset){
		SoapObject allNotice=(SoapObject) dataset.getProperty("AllNotice");
		int noticecount=allNotice.getPropertyCount();
		for (int i = 0; i < noticecount; i++) {
			SoapObject soapChilds = (SoapObject) dataset.getProperty(i);
			String postID = soapChilds.getProperty("postID").toString();
			String postTitle = soapChilds.getProperty("postTitle").toString();
			String postContent = soapChilds.getProperty("postContent").toString();
			String postDate = soapChilds.getProperty("postDate").toString();
			String postPersonName = soapChilds.getProperty("postPersonName").toString();
			String postContentText = soapChilds.getProperty("postContentText").toString();
			noticeEntity = new NoticeEntity();
			noticeEntity.setPostID(postID);
			noticeEntity.setPostTitle(postTitle);
			noticeEntity.setPostContent(postContent);
			noticeEntity.setPostDate(postDate);
			noticeEntity.setPostPersonName(postPersonName);
			noticeEntity.setPostContentText(postContentText);
			datalist.add(noticeEntity);
		}
		return datalist;
	}
}
