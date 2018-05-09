package com.liuhe.redpacket.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成唯一订单号
 * 
 * @author ozil
 *
 */
public class OrderNumUtil {
	
	/**
	 * 商品总订单前缀
	 */
	public static final String TOTAL_PRE = "0";
	/**
	 * 商品订单号前缀
	 */
	public static final String PRODUCT_PRE = "1";
	/**
	 * 广告订单号前缀
	 */
	public static final String PROMOTION_PRE = "2";
	/**
	 * 保证金订单号前缀
	 */
	public static final String MARGIN_PRE = "3";
	/**
	 * 加入团队订单号前缀
	 */
	public static final String JOINTEAM_PRE = "4";
	/**
	 * 退款订单号前缀
	 */
	public static final String REFUND_PRE = "9";

//	private OrderNumUtil() {
//	}

	/**
	 * System.currentTimeMillis() 1970到当前时间的毫秒数
	 */
	// public static String getOrderNum() {
	// return (System.currentTimeMillis() + "").substring(1)
	// + (System.nanoTime() + "").substring(7, 10)+(new
	// Random().nextInt(90000)+10000);
	// }
	/**
	 * 获取订单号
	 * System.nanoTime() 当前纳秒数,同一毫秒内后三位不同 orderType 订单类型
	 * @return
	 */
	public static String getOrderNum() {
		// 到毫秒
		String date = new SimpleDateFormat("MMddHHmmssSSS")
				.format(new Date());
		// 纳秒
		String time = (System.nanoTime() + "").substring(7, 10);
		//id
		return date + time;
	}

	/**
	 * 根据用户id和订单类型生成订单号
	 * 
	 * @param id
	 *            用户id 
	 * @return
	 */
	public static String getOrderNum(Long id) {
		// 时间
		String date = new SimpleDateFormat("MMddHHmmss").format(new Date());
		// 用户id
		String userId = "00000" + id;
		int length = userId.length();
		userId = userId.substring(length - 6, length);
		return date + userId;
	}
	
	/**
	 * 根据订单号获取id
	 * 
	 * @param orderNum
	 * @return
	 */
	public static Long getId(String orderNum) {
		int length = orderNum.length();
		String id = orderNum.substring(length - 6, length);
		return new Long(id);
	}
	/**
	 * 获取订单类型
	 * @param orderNum
	 * @return
	 */
	public static String getOrderType(String orderNum) {
		String type = orderNum.substring(0, 1);
		return type;
	}
	
}
