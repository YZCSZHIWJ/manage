package com.ddz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceDao {
	/**
	 * 提现数目统计
	 * @author wangjian
	 * @time 2016年9月22日
	 * @param userid 用户id 
	 * @param last4  银行账号后4位
	 * @param status 状态  0.待审核，1.通过，2.不通过
	 * @param isout -1.全部，0.未导出，1.已导出，2.完成
	 * @param starttime 请求时间区间
	 * @param endtime
	 * @return
	 */
	int getMoneyReqNum(@Param("userid")long userid, @Param("last4")String last4, @Param("status")int status,
			@Param("isout")int isout, @Param("starttime")String starttime, @Param("endtime")String endtime);
	/**
	 * 提现数据
	 * @author wangjian
	 * @time 2016年9月22日
	 * @param userid 用户id
	 * @param last4  银行账号后4位
	 * @param status 状态  0.待审核，1.通过，2.不通过
	 * @param isout -1.全部，0.未导出，1.已导出，2.完成
	 * @param starttime 请求时间区间
	 * @param endtime
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getMoneyReqLst(@Param("userid")long userid, @Param("last4")String last4, @Param("status")int status,
			@Param("isout")int isout, @Param("starttime")String starttime, @Param("endtime")String endtime, 
			@Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
}
