package com.ddz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealDao {
	/**
	 * 统计申诉数目
	 * @author Administrator
	 * 2016年9月13日
	 * @param orderid 订单id
	 * @param userid 申诉者
	 * @param beuserid 被申诉者
	 * @param appeal_type
	 * @param status 申诉状态  0.初始，1.受理中，2.已完成 
	 * @param plat_join_status 平台是否参与，0.否，1.是
	 * @param starttime 发起时间区间
	 * @param endtime
	 * @return
	 */
	int countAppealNum(@Param("orderid")long orderid, @Param("userid")long userid, @Param("beuserid")long beuserid, @Param("appeal_type")int appeal_type,
			@Param("status")int status, @Param("plat_join_status")int plat_join_status, @Param("starttime")String starttime, @Param("endtime")String endtime);
	/**
	 * 申诉数据
	 * @author Administrator
	 * 2016年9月13日
	 * @param orderid 订单id
	 * @param userid  申诉者
	 * @param beuserid  被申诉者
	 * @param appeal_type
	 * @param status 申诉状态  0.初始，1.受理中，2.已完成 
	 * @param plat_join_status  平台是否参与，0.否，1.是
	 * @param starttime 发起时间区间
	 * @param endtime
	 * @param firstPage 
	 * @param pageSize
	 * @return
	 */
	List getAppealLst(@Param("orderid")long orderid, @Param("userid")long userid, @Param("beuserid")long beuserid, @Param("appeal_type")int appeal_type,
			@Param("status")int status, @Param("plat_join_status")int plat_join_status, @Param("starttime")String starttime, @Param("endtime")String endtime,
			@Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 申诉回复
	 * @author Administrator
	 * 2016年9月13日
	 * @param map
	 */
	void backAppeal(Map map);
	/**
	 * 完结申诉
	 * @param orderid 订单id
	 * @param isflow 是否浏览单，0.否，1.是
	 * @param admin 完结管理员
	 * @return
	 */
	int overAppeal(@Param("orderid")long orderid, @Param("isflow")int isflow, @Param("admin")String admin);
	/**
	 * 获取申诉对话内容
	 * @param orderid
	 * @param isflow
	 * @return
	 */
	List getAppealContent(@Param("orderid")long orderid, @Param("isflow")int isflow);
	/**
	 * 获取申诉主内容
	 * @author Administrator
	 * 2016年9月19日
	 * @param orderid
	 * @param isflow
	 * @return
	 */
	Map getAppealMain(@Param("orderid")long orderid, @Param("isflow")int isflow);
}
