package com.ddz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
	/**
	 * 统计浏览单数目
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 订单id
	 * @param tid 任务id
	 * @param userid 买手id
	 * @param sellerid 商家id
	 * @param account 买手买号
	 * @param plat 平台，1.淘宝，2.天猫，3.京东
	 * @param device 操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @return
	 */
	int countFlowOrderNum(@Param("id")long id, @Param("tid")long tid, @Param("userid")long userid, @Param("sellerid")long sellerid, 
			@Param("account")String account, @Param("plat")int plat, @Param("device")int device, @Param("status")int status);
	/**
	 * 获取浏览单列表信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 订单id
	 * @param tid 任务id
	 * @param userid 买手id
	 * @param sellerid  商家id
	 * @param account 买手买号
	 * @param plat 平台，1.淘宝，2.天猫，3.京东
	 * @param device 操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getFlowOrderLst(@Param("id")long id, @Param("tid")long tid, @Param("userid")long userid, @Param("sellerid")long sellerid, @Param("account")String account,
			 @Param("plat")int plat, @Param("device")int device, @Param("status")int status, @Param("firstPage")int firstPage, @Param("pageSize") int pageSize);
	/**
	 * 获取浏览单详情信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 订单id
	 * @return
	 */
	Map getFlowOrderDetail(long id);
	/**
	 * 撤销浏览订单
	 * @author Administrator
	 * 2016年8月25日
	 * @param map
	 */
	void cancelFlowOrder(Map map);
	
	/**
	 * 统计已撤销浏览单数目
	 * @author Administrator
	 * 2016年8月11日
	 * @param tid 任务id
	 * @param id 订单id
	 * @param userid 买手id
	 * @param sellerid 商家id
	 * @param account 买手买号
	 * @param plat 平台，1.淘宝，2.天猫，3.京东
	 * @param device 操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @return
	 */
	int countCanceledFlowOrderNum(@Param("tid")long tid, @Param("id")long id, @Param("userid")long userid, @Param("sellerid")long sellerid, 
			@Param("account")String account, @Param("plat")int plat, @Param("device")int device, @Param("status")int status);
	/**
	 * 获取已撤销浏览单列表信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param tid 任务id
	 * @param id 订单id
	 * @param userid 买手id
	 * @param sellerid  商家id
	 * @param account 买手买号
	 * @param plat 平台，1.淘宝，2.天猫，3.京东
	 * @param device 操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getCanceledFlowOrderLst(@Param("tid")long tid, @Param("id")long id, @Param("userid")long userid, @Param("sellerid")long sellerid, @Param("account")String account,
			 @Param("plat")int plat, @Param("device")int device, @Param("status")int status, @Param("firstPage")int firstPage, @Param("pageSize") int pageSize);
	
	/**
	 * 获取已撤销的浏览单详情信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 订单id
	 * @return
	 */
	Map getCanceledFlowOrderDetail(long id);
}
