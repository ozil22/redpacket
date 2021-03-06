package com.liuhe.redpacket.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 短信
 * 
 * @author ozil
 *
 */
public class SMSUtil {
	private static String url = null;// 请求地址
	private static String sid = null;// 主账户id
	private static String appId = null;// 应用id
	private static String token = null;// 验证信息
	static {
		if (url == null) {
			url = ReadProperties.getUrl();
		}
		if (sid == null) {
			sid = ReadProperties.getSid();
		}
		if (appId == null) {
			appId = ReadProperties.getAppId();
		}
		if (token == null) {
			token = ReadProperties.getToken();
		}
	}

	/**
	 * 发送短信
	 * 
	 * @param templateId
	 *            模板id
	 * @param to
	 *            短信接收端手机号码（国内短信不要加前缀，国际短信号码前须带相应的国家区号，如日本：0081）
	 * @param param
	 *            内容数据，用于替换模板中{数字}，若有多个替换内容，用英文逗号隔开即可
	 * @return "resp": {
	 * 				"respCode": 请求状态码，取值000000（成功）,
	 * 			    "failure": 表示短信验证码发送失败的条数,
	 * 				"templateSMS": {
	 * 					"createDate": 短信的创建时间
	 *					"smsId": 短信标识符。一个由32个字符组成的短信唯一标识符
	 *				}
	 *			}
	 */
	public static Map<String, Object> sendSMS(String templateId, String to,
			String param) {
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date());
		String sign = MD5Util.md5(sid + time + token);
		String params = "sid=" + sid + "&appId=" + appId + "&sign=" + sign
				+ "&time=" + time + "&templateId=" + templateId
				+ "&to=" + to + "&param=" + param;
		String sendPost = HttpRequest.sendPost(url, params);
		System.out.println(sendPost);
//		String sendPost = HttpRequest.sendPost(url, params);
		//String result = HttpRequest.sendPost(url, params);
//		Map<String, Object> map = JsonUtil.toMap(result);
		return null;
	}
	
}
