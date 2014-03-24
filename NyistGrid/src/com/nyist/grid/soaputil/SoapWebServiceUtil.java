package com.nyist.grid.soaputil;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParserException;

import com.nyist.grid.soapcode.NewHttpTransportSE;

/**
 * Soap WebService帮助类
 * 
 * @author guang.shu@magic-point.com
 * @date Mar 27, 201311:07:43 PM
 * @version
 */

public class SoapWebServiceUtil {
	private static SoapObject response;
	private static SoapObject detail;
	private static SoapObject newdataset;
	/**
	 * 不带SoapHeader的Webservice数据
	 * @author guang.shu@magic-point.com
	 * @date Mar 27, 201311:30:04 PM
	 * @version
	 * @param  namespace 命名空间
	 * @param  methodname 方法名
	 * @param  webserviceUrl Url
	 * @param  soapaction Namespace+Methodname
	 * 
	 * @return newdataset SoapObject类型的NewDataSet
	 */
	public static SoapObject GetSoapWebServiceData(String namespace,
			String methodname, String webserviceUrl, String soapaction) {

		try {
			SoapObject rpc = new SoapObject(namespace, methodname);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.bodyOut = rpc;
			envelope.dotNet = true;
			envelope.setOutputSoapObject(rpc);
			NewHttpTransportSE ht = new NewHttpTransportSE(webserviceUrl);
			ht.debug = true;
			ht.call(soapaction, envelope, null);
			response = (SoapObject) envelope.getResponse();
			detail = (SoapObject) response.getProperty(1);
			newdataset = (SoapObject) detail.getProperty("NewDataSet");
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (SoapFault e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return newdataset;
	}
}
