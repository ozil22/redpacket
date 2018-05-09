package com.liuhe.redpacket.vo.weixin.pay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.liuhe.redpacket.vo.weixin.adapter.AdapterCDATA;

@XmlRootElement(name = "xml")
public class QueryRes {
	private String returnCode;
	private String returnMsg;
	private String appid;
	private String mchId;
	private String nonceStr;
	private String sign;
	private String resultCode;
	private String errCode;
	private String errCodeDes;
	private String deviceInfo;
	private String openid;
	private String isSubscribe;
	private String tradeType;
	private String tradeState;
	private String bankType;
	private Integer totalFee;
	private String feeType;
	private Integer cashFee;
	private String cashFeeType;
	private String transactionId;
	private String outTradeNo;
	private String attach;
	private String timeEnd;
	private String tradeStateDesc;

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "return_code")
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "return_msg")
	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "appid")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "mch_id")
	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "nonce_str")
	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "sign")
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "result_code")
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "err_code")
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "err_code_des")
	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "device_info")
	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "openid")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "is_subscribe")
	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "trade_type")
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "trade_state")
	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "bank_type")
	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	@XmlElement(name = "total_fee")
	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "fee_type")
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	@XmlElement(name = "cash_fee")
	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "cash_fee_type")
	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "out_trade_no")
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "attach")
	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "time_end")
	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	@XmlJavaTypeAdapter(AdapterCDATA.class)
	@XmlElement(name = "trade_state_desc")
	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}
}
