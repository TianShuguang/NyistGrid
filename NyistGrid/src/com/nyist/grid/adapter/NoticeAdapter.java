package com.nyist.grid.adapter;

import java.util.ArrayList;
import java.util.List;

import com.nyist.grid.R;
import com.nyist.grid.entity.NoticeEntity;
import com.nyist.grid.util.ValueUtil;
import com.nyist.grid.util.ViewUtil;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoticeAdapter extends BaseAdapter{
	public static final String TAG = "NoticeAdapter";
	protected List<NoticeEntity> noticeList=new ArrayList<NoticeEntity>();
	
	private class ViewHolder {
		public TextView tvNoticeTitle;
		public TextView tvNoticeDate;
		public TextView tvNoticePerson;
	}
	
	public NoticeAdapter(List<NoticeEntity> noticeList) {
		if (ValueUtil.isNotEmpty(noticeList)) {
			this.noticeList = noticeList;
		} else {
			this.noticeList = new ArrayList<NoticeEntity>();
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return noticeList.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (null==convertView) {
			convertView=ViewUtil.buildView(R.layout.notice_list_item);
			holder=new ViewHolder();
			convertView.setTag(holder);
			holder.tvNoticeTitle=(TextView) convertView.findViewById(R.id.tvNoticeTitle);
			holder.tvNoticeDate=(TextView) convertView.findViewById(R.id.tvNoticeDate);
			holder.tvNoticePerson=(TextView) convertView.findViewById(R.id.tvNoticePerson);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		
		String oldTime = noticeList.get(position).getPostDate();
		String newTime = oldTime.substring(0, 10) + " "
				+ oldTime.substring(11, 19);
		holder.tvNoticeTitle.setText(noticeList.get(position).getPostTitle());
		holder.tvNoticePerson.setText(noticeList.get(position).getPostPersonName());
		holder.tvNoticeDate.setText(newTime);
		return convertView;
	}
	
	/**
	 * 该方法为了防止dataList引用断掉
	 * 
	 * @author carlos E-mail:carloscyy@gmail.com
	 * @version 创建时间：2011-11-22 上午11:13:38
	 * @param dataList
	 */
	public void notifyDataSetChanged(List<NoticeEntity> noticeList) {
		this.noticeList = noticeList;
		notifyDataSetChanged();
	}

}
