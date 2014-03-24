package com.nyist.grid.base.constant;

/**
 * 服务端固定数据
 * @author guang.shu@magic-point.com
 * @date Mar 29, 20137:54:10 PM
 * @version 
 */
public class WebConstant {
	//NameSpace
	public static final String NAMESPACE = "http://soft-bysj.nyist.net/";
	//URL
	public static final String PUBLIC_WEBSERVICE_URL = "http://61.163.231.201/webservice/publicWebService.asmx";
	//MethodName
	public static final String GETNOTICE_METHOD_NAME = "GetAllNotice";
	//SoapAction
	public static final String GETNOTICE_SOAP_ACTION = NAMESPACE + GETNOTICE_METHOD_NAME;
}
