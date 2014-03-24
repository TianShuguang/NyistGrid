package com.nyist.grid.base;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.nyist.grid.R;
import com.nyist.grid.adapter.BaseGridAdapter;
import com.nyist.grid.entity.GridRowEntity;

/**
 * 所有九宫格的基类
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201311:04:28 AM
 * @version 
 */
public abstract class BaseGridActivity extends BaseActivity{
	private GridView mgridView;
	private List<GridRowEntity> gridRowDomainList = new ArrayList<GridRowEntity>();
	private BaseGridAdapter adapter;
	
	@Override
	protected void installViews() {
		setContentView(R.layout.base_grid_activity);
		mgridView=(GridView) this.findViewById(R.id.my_grid);
		gridRowDomainList = getGridRowDomains();
		adapter = new BaseGridAdapter(gridRowDomainList);
		mgridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		mgridView.setAdapter(adapter);
	}

	@Override
	protected void registerEvents() {
		mgridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				onClickGridItem(arg2);
			}
		});
		
	}

	@Override
	public void refresh(Object... param) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 获取九宫格域对象列表
	 * 
	 * @author carlos carlosk@163.com
	 * @version 创建时间：2012-11-13 下午4:35:48
	 * @return
	 */
	protected abstract List<GridRowEntity> getGridRowDomains();

	protected abstract void onClickGridItem(int index);
}
