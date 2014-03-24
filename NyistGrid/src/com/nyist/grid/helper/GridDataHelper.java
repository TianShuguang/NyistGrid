package com.nyist.grid.helper;

import java.util.ArrayList;
import java.util.List;

import com.nyist.grid.R;
import com.nyist.grid.entity.GridRowEntity;
import com.nyist.grid.util.ValueUtil;

/**
 * 九宫格的帮助类
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 26, 201310:59:40 PM
 * @version
 */
public class GridDataHelper {
	// 首页的九宫格
	public static List<GridRowEntity> getHomeDatas() {
		List<GridRowEntity> resultList = new ArrayList<GridRowEntity>();
		int[] titlesRes = { R.string.main_notice, R.string.main_massage,
				R.string.main_list, R.string.main_mine, R.string.main_advise,
				R.string.main_about };
		fillGridRowDomainListByTitlesRes(titlesRes, resultList, "main");
		return resultList;
	}

	// 日志的九宫格
	public static List<GridRowEntity> getMessageDatas() {
		List<GridRowEntity> resultList = new ArrayList<GridRowEntity>();
		int[] titlesRes = { R.string.message_my, R.string.message_teacher,
				R.string.message_help};
		fillGridRowDomainListByTitlesRes(titlesRes, resultList, "message");
		return resultList;
	}

	// 课题的九宫格
	public static List<GridRowEntity> getListDatas() {
		List<GridRowEntity> resultList = new ArrayList<GridRowEntity>();
		int[] titlesRes = { R.string.list_list, R.string.list_my,
				R.string.list_search, R.string.list_help };
		fillGridRowDomainListByTitlesRes(titlesRes, resultList, "list");
		return resultList;
	}

	// 个人的九宫格
	public static List<GridRowEntity> getMineDatas() {
		List<GridRowEntity> resultList = new ArrayList<GridRowEntity>();
		int[] titlesRes = { R.string.mine_progre, R.string.mine_message,
				R.string.mine_teacher, R.string.mine_help };
		fillGridRowDomainListByTitlesRes(titlesRes, resultList, "mine");
		return resultList;
	}

	/**
	 * 
	 * @param titlesRes
	 * @param resultList
	 * @param prefix
	 *            图片名称的前缀
	 * @param partIndex
	 *            不同的模块对应的Index
	 * 
	 * @author guang.shu@magic-point.com
	 */
	private static void fillGridRowDomainListByTitlesRes(int[] titlesRes,
			List<GridRowEntity> resultList, String prefix) {
		int eachTitlesRis = 0;
		for (int i = 0; i < titlesRes.length; i++) {
			eachTitlesRis = titlesRes[i];
			GridRowEntity eachDomain = new GridRowEntity();
			eachDomain.setTitle(ValueUtil.getString(eachTitlesRis));
			eachDomain.setNormalBgName(prefix + "_0" + (i + 1) + "_normal");
			eachDomain.setPressedBgName(prefix + "_0" + (i + 1) + "_press");

			resultList.add(eachDomain);
		}
	}
}
