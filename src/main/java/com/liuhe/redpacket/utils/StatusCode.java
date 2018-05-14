package com.liuhe.redpacket.utils;
/**
 * 状态码
 * @author ozil
 *
 */
public class StatusCode {
	//=============================账户相关==================================
	/**
	 * 用户名错误
	 */
	public static final Integer USERNAME_ERROR = -100;
	/**
	 * 密码错误
	 */
	public static final Integer PASSWORD_ERROR = -101;
	/**
	 * 验证码错误
	 */
	public static final Integer RANDOM_ERROR = -102;
	/**
	 * 账号状态异常,已停用！！
	 */
	public static final Integer STATE_ERROR = -103;
	/**
	 * 用户已存在
	 */
	public static final Integer USERNAME_EXISTING = -104;
	/**
	 * 收货地址不存在
	 */
	public static final Integer ADDRESS_NOTFOUND = -105;
	/**
	 * 邀请码无效
	 */
	public static final Integer USER_USECODE_INVALID = -106;
	/**
	 * 账户未停用,不能删除
	 */
	public static final Integer USER_NOTDELETE = -107;
	/**
	 * 该微信号还未绑定任何账户
	 */
	public static final Integer USER_NOWECHAT = -108;
	/**
	 * 不能修改管理员账户
	 */
	public static final Integer USER_NOTEDIT_ADMIN = -109;
	/**
	 * 账户余额不足
	 */
	public static final Integer ACCOUNT_NO_BALANCE = -110;
	/**
	 * 该用户还未加入团队
	 */
	public static final Integer USER_NOT_JOINTEAM = -111;
	//=============================商品相关==================================
	/**
	 * 商品不存在
	 */
	public static final Integer GOODS_NOTFOUND = -200;
	/**
	 * 商品库存不足
	 */
	public static final Integer GOODS_NONUM = -201;
	/**
	 * 商品未下架,不能删除
	 */
	public static final Integer GOODS_NOTDELETE = -202;
	/**
	 * 该分类存在下级分类,不能删除
	 */
	public static final Integer TYPE_NOTDELETE = -203;
	/**
	 * 存在该分类的商品,不能删除
	 */
	public static final Integer TYPE_GOODS_NOTDELETE = -204;
	/**
	 * 存在该分类的商品,不能删除
	 */
	public static final Integer BRAND_NOTDELETE = -205;
	/**
	 * 商品转发价不能低于原价
	 */
	public static final Integer PROXY_PRICE_TOOLOW = -206;
	//=============================商品订单相关==================================
	/**
	 * 订单不能修改价格
	 */
	public static final Integer PRODUCTORDER_NOTEDIT_PRICE = -210;
	/**
	 * 订单不能关闭
	 */
	public static final Integer PRODUCTORDER_NOTCANCEL = -211;
	/**
	 * 订单不能删除
	 */
	public static final Integer PRODUCTORDER_NOTDELETE = -212;
	//=============================店铺相关==================================
	/**
	 * 店铺不存在
	 */
	public static final Integer STRORE_NOTFOUND = -300;
	/**
	 * 店铺不是待审核状态
	 */
	public static final Integer STRORE_NOTAUTH = -301;
	//=============================广告相关==================================
	/**
	 * 该广告位还有未失效的广告,不能删除!
	 */
	public static final Integer ADPOSITIONID_NOTDELETE = -400;
	/**
	 * 审核通过的广告,不能删除!
	 */
	public static final Integer PROMOTION_NOTDELETE = -401;
	/**
	 * 审核通过的广告,不能删除!
	 */
	public static final Integer PROMOTION_NOTBUY = -402;
	//=============================文章相关==================================
	/**
	 * 该文章不是自己的,不能删除!
	 */
	public static final Integer ARTICLE_NOTDELETE = -500;
	/**
	 * 该分类还有存在文章，不能删除！
	 */
	public static final Integer ARTICLETYPE_NOTDELETE = -501;
	/**
	 * 该分类已存在!
	 */
	public static final Integer ARTICLETYPE_EXIST = -502;
	
}