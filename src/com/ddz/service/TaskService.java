package com.ddz.service;

import java.util.List;
import java.util.Map;

public interface TaskService {
	/**
	 * 统计已经审核的浏览任务数
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param progress 任务进度，-1.全部，0.未接单， 1.待操作，2.待确认，3.已完成
	 * @return
	 */
	int countAuditedFlowTaskNum(long id, long userid, int plat, int progress);
	/**
	 * 获取已审核的浏览任务信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param progress 任务进度，-1.全部，0.未接单， 1.待操作，2.待确认，3.已完成
	 * @param firstPage 
	 * @param pageSize
	 * @return
	 */
	List getAuditedFlowTaskLst(long id, long userid, int plat, int progress, int firstPage, int pageSize);
	/**
	 * 浏览任务详情
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	Map getFlowTaskDetail(long id);
	/**
	 * 浏览任务限制信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	Map getFlowTaskLimit(long id);
	/**
	 * 浏览任务定时设置
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	Map getFlowTaskTimeset(long id);
	/**
	 * 浏览任务搜索关键词设置
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	List getFlowTaskKeywordes(long id);
	/**
	 * 获取浏览任务支付信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	Map getFlowTaskPay(long id);
}
