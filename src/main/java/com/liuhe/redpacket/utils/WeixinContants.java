package com.liuhe.redpacket.utils;

/**
 * 微信相关的常量
 * 
 * @author admin
 *
 */
public class WeixinContants {
	// appid 是 第三方用户唯一凭证
	public static final String APPID = "wx1eb07ef94c60422f";
//	public static final String APPID = "wx1b493d862116a3ba";//测试
	// secret 是 第三方用户唯一凭证密钥，即appsecret
	public static final String APPSECRET = "300ac051f1896c5975f5800ce0982f6e";
//	public static final String APPSECRET = "931ab10cae6e972d3110b0a983b0d9ed";//测试
	//获取AccessToken的url
	public static final String GET_ACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//AccessToken
	public static String ACCESSTOKEN = "CvwQl63vbCv1qj6tkewwbg32zCu8k9BIyfTbLxZdxlwDvG_wm1xG4D3qqg9C4Bkqi7Q8zBrJ4BL1w42raGGFnyPrwJQzgmLmRyWjdmZxx9P5IBPQLjHCYeiYU62-tPDVKBCdAGACTU";
	//获取菜单的url
	public static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	//删除菜单的url
	public static final String DEL_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//添加菜单的url
	public static final String ADD_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//发起授权请求
	public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//发起获取用户OPENID
	public static final String GET_OPENID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//刷新token
	public static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//发起获取用户信息
	public static final String GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}	

