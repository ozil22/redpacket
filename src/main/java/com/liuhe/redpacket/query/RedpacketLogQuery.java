/*
 * Powered By [chan]
 * Web Site: http://wealthlake.cn
 * Since 2012 - 2017
 */

package com.liuhe.redpacket.query;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class RedpacketLogQuery extends BaseQuery implements Serializable {
	private static final long serialVersionUID = 3148176768559230877L;

	private java.lang.Long qrCodeId;
	private java.lang.Long redpacketId;
	private java.lang.String openid;
	private String adTitle;
	private String beginTime;
	private String endTime;

	public java.lang.Long getQrCodeId() {
		return qrCodeId;
	}

	public void setQrCodeId(java.lang.Long qrCodeId) {
		this.qrCodeId = qrCodeId;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = StringUtils.isBlank(beginTime) ? null : beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = StringUtils.isBlank(endTime) ? null : endTime;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}
	

	public java.lang.Long getRedpacketId() {
		return redpacketId;
	}

	public void setRedpacketId(java.lang.Long redpacketId) {
		this.redpacketId = redpacketId;
	}

	public java.lang.String getOpenid() {
		return openid;
	}

	public void setOpenid(java.lang.String openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "RedpacketLogQuery [QrCodeId=" + qrCodeId + ", redpacketId="
				+ redpacketId + ", openid=" + openid + ", adTitle=" + adTitle
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}

}
