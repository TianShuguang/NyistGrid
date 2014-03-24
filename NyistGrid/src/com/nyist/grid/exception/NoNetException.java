package com.nyist.grid.exception;

import com.nyist.grid.util.common.LogFactory;

/**
 * @author guang.shu@magic-point.com
 * @date Mar 29, 20134:52:31 PM
 * @version 
 * @Description: 没有网络异常
 */
public class NoNetException extends Exception{

	private static final long serialVersionUID = 1L;
	private final static String TAG="NoNetException";
	public NoNetException() {
		super();
		LogFactory.e(TAG, "No net exception....");
	}

	public NoNetException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

	public NoNetException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public NoNetException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

}
