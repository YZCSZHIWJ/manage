package com.ddz.service;

import java.util.List;
import java.util.Map;

public interface AppealService {
	/**
	 * 申诉统计
	 * @author Administrator
	 * 2016年9月13日
	 * @param orderid 订单id
	 * @param userid 申诉者
	 * @param beuserid 被申诉者
	 * @param appeal_type
	 * @param status 申诉状态  0.初始，1.受理中，2.已完成 
	 * @param plat_join_status  平台是否参与，0.否，1.是
	 * @param starttime 发起时间区间
	 * @param endtime
	 * @return
	 */
	int countAppealNum(long orderid, long userid, long beuserid, int appeal_type, int status, 
			int plat_join_status, String starttime, String endtime);
	/**
	 * 申诉数据
	 * @author Administrator
	 * 2016年9月13日
	 * @param orderid 订单id
	 * @param userid 申诉者
	 * @param beuserid  被申诉者
	 * @param appeal_type
	 * @param status 申诉状态  0.初始，1.受理中，2.已完成 
	 * @param plat_join_status 平台是否参与，0.否，1.是
	 * @param starttime 发起时间区间
	 * @param endtime
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getAppealLst(long orderid, long userid, long beuserid, int appeal_type, int status, 
			int plat_join_status, String starttime, String endtime, int firstPage, int pageSize);
	/**
	 * 申诉回复
	 * @author Administrator
	 * 2016年9月13日
	 * @param orderid  订单id
	 * @param isflow 0.垫付，1.浏览
	 * @param admin 回复的管理员 
	 * @param content 回复的内容
	 * @return
	 */
	Map backAppeal(long orderid, int isflow, String admin, String content);
	/**
	 * 完结申诉
	 * @param orderid 订单id
	 * @param isflow 0.垫付，1.浏览
	 * @param admin 完结操作管理员
	 * @return
	 */
	boolean overAppeal(long orderid, int isflow, String admin);
	/**
	 * 申诉对话内容
	 * @param orderid
	 * @param isflow
	 * @return
	 */
	List getAppealContent(long orderid, int isflow);
	/**
	 * 申诉内容
	 * @author Administrator
	 * 2016年9月19日
	 * @param orderid
	 * @param isflow
	 * @return
	 */
	Map getAppealMain(long orderid, int isflow);
}
