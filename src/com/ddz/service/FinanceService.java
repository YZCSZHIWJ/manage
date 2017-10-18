package com.ddz.service;

import java.util.List;

public interface FinanceService {
	/**
	 * 统计提现数目
	 * @author wangjian
	 * @time 2016年9月22日
	 * @param userid 用户id
	 * @param last4  银行账号后4位
	 * @param status 状态  0.待审核，1.通过，2.不通过
	 * @param isout -1.全部，0.未导出，1.已导出，2.完成
	 * @param starttime  请求时间区间
	 * @param endtime
	 * @return
	 */
	int countReqGetMoneyNum(long userid, String last4, int status, int isout, String starttime, String endtime);
	/**
	 * 提现数据列表
	 * @author wangjian
	 * @time 2016年9月22日
	 * @param userid 用户id
	 * @param last4  银行账号后4位
	 * @param status 状态  0.待审核，1.通过，2.不通过
	 * @param isout -1.全部，0.未导出，1.已导出，2.完成
	 * @param starttime  请求时间区间
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getReqGetMoneyLst(long userid, String last4, int status, int isout, String starttime, String endtime, int firstPage, int pageSize);
}
