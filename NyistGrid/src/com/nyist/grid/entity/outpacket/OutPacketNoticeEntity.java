package com.nyist.grid.entity.outpacket;

import com.nyist.grid.entity.BaseEntity;

public class OutPacketNoticeEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String namespace;
	private String methodname;
	private String webserviceUrl;
	private String soapaction;
	/**
	 * 
	 * @param  namespace 命名空间
	 * @param  methodname 方法名
	 * @param  webserviceUrl Url
	 * @param  soapaction namespace+methodname
	 */
	
	public String getNamespace() {
		return namespace;
	}
	public OutPacketNoticeEntity(String namespace,String methodname,
			String webserviceUrl,String soapaction) {
		super();
		this.namespace=namespace;
		this.methodname=methodname;
		this.webserviceUrl=webserviceUrl;
		this.soapaction=soapaction;
		
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public String getWebserviceUrl() {
		return webserviceUrl;
	}
	public void setWebserviceUrl(String webserviceUrl) {
		this.webserviceUrl = webserviceUrl;
	}
	public String getSoapaction() {
		return soapaction;
	}
	public void setSoapaction(String soapaction) {
		this.soapaction = soapaction;
	}
	
}
