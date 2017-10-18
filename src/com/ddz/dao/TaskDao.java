package com.ddz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao {
	/**
	 * 统计浏览任务数
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param id 任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param status 任务状态  0.未审核，1.已审核，2.已完成，3.不通过，4.被冻结
	 * @return
	 */
	int countFlowTaskNum(@Param("id")long id, @Param("userid")long userid, @Param("plat")int plat, @Param("status")int status);
	/**
	 * 获取浏览任务数据
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param id 任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param status  任务状态 -1.全部， 0.未审核，1.已审核，2.已完成，3.不通过，4.被冻结
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getFlowTaskLst(@Param("id")long id, @Param("userid")long userid, @Param("plat")int plat, 
			@Param("status")int status, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 已审核的浏览任务数
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param progress 任务进度，-1.全部，0.未接单， 1.待操作，2.待确认，3.已完成
	 * @return
	 */
	int countAuditedFlowTaskNum(@Param("id")long id, @Param("userid")long userid, @Param("plat")int plat, @Param("progress")int progress);
	/**
	 * 已审核的浏览任务列表
	 * @author Administrator
	 * 2016年8月11日
	 * @param id  任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param progress  任务进度，-1.全部，0.未接单， 1.待操作，2.待确认，3.已完成
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getAuditedFlowTaskLst(@Param("id")long id, @Param("userid")long userid, @Param("plat")int plat, 
			@Param("progress")int progress, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 浏览任务详情
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 任务id
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
	 * 获取浏览任务定时设置
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	Map getFlowTaskTimeSet(long id);
	/**
	 * 获取浏览任务订单支付信息
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	Map getFlowTaskPay(long id);
	/**
	 * 获取浏览任务搜索关键词设置
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @return
	 */
	List getFlowTaskKeywordes(long id);
}
