package com.ddz.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
	/**
	 * 浏览订单统计
	 * @author Administrator
	 * 2016年8月11日
	 * @param id  订单id
	 * @param tid 任务id
	 * @param userid 买手id
	 * @param sellerid 商家id
	 * @param account  买手买号
	 * @param plat  平台，1.淘宝，2.天猫，3.京东
	 * @param device  操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @return
	 */
	int countFlowOrderNum(long id, long tid, long userid, long sellerid, String account, int plat, int device, int status);
	/**
	 * 浏览订单列表
	 * @author Administrator
	 * 2016年8月11日
	 * @param id　订单id
	 * @param tid　任务id
	 * @param userid　 买手id
	 * @param sellerid　商家id
	 * @param account　买手买号
	 * @param plat　 平台，1.淘宝，2.天猫，3.京东
	 * @param device　操作设备 1.手机，2.电脑　
	 * @param status　状态 0.待操作，1.待确认，2.完成
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getFlowOrderLst(long id, long tid, long userid, long sellerid, String account, int plat, int device, int status, int firstPage, int pageSize);
	/**
	 * 浏览订单详情
	 * @author Administrator
	 * 2016年8月25日
	 * @param id 订单id
	 * @return
	 */
	Map getFlowOrderDetail(long id);
	/**
	 * 撤销浏览单给其他用户接手
	 * @author Administrator
	 * 2016年8月25日
	 * @param id 订单id
	 * @param userid 买手id
	 * @param remark 撤销备注
	 * @param admin 撤销管理员
	 * @return
	 */
	Map cancelFlowOrder(long id, long userid, String remark, String admin);
	/**
	 * 已撤销浏览订单数统计
	 * @author Administrator
	 * 2016年8月11日
	 * @param id  订单id
	 * @param tid 任务id
	 * @param userid 买手id
	 * @param sellerid 商家id
	 * @param account  买手买号
	 * @param plat  平台，1.淘宝，2.天猫，3.京东
	 * @param device  操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @return
	 */
	int countCanceledFlowOrderNum(long id, long tid, long userid, long sellerid, String account, int plat, int device, int status);
	/**
	 * 已撤销浏览订单列表
	 * @author Administrator
	 * 2016年8月11日
	 * @param id　订单id
	 * @param tid　任务id
	 * @param userid　 买手id
	 * @param sellerid　商家id
	 * @param account　买手买号
	 * @param plat　 平台，1.淘宝，2.天猫，3.京东
	 * @param device　操作设备 1.手机，2.电脑　
	 * @param status　状态 0.待操作，1.待确认，2.完成
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getCanceledFlowOrderLst(long id, long tid, long userid, long sellerid, String account, int plat, int device, int status, int firstPage, int pageSize);
	/**
	 * 已撤销浏览订单详情
	 * @author Administrator
	 * 2016年8月25日
	 * @param id 订单id
	 * @return
	 */
	Map getCanceledFlowOrderDetail(long id);
}
