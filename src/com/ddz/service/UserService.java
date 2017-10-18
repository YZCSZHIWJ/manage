package com.ddz.service;

import java.util.List;

import com.ddz.model.Account;
import com.ddz.model.User;

public interface UserService {
	/**
	 * 用户id获取用户详情
	 * @author wangjian
	 * @time 2016年7月26日
	 * @param userid
	 * @return
	 */
	User getUserById(long userid);
	/**
	 * 手机号码获取用户详情
	 * @author wangjian
	 * @time 2016年7月26日
	 * @param mobile
	 * @return
	 */
	User getUserByMobile(long mobile);
	/**
	 * 获取用户账户信息
	 * @author wangjian
	 * @time 2016年7月26日
	 * @param userid
	 * @return
	 */
	Account getUserAccountById(long userid);
	/**
	 * 获取用户绑定账号信息
	 * @author wangjian
	 * @time 2016年7月27日
	 * @param userid
	 * @return
	 */
	List getUserBindList(long userid);
	/**
	 * 获取用户绑定银行账户信息
	 * @author wangjian
	 * @time 2016年7月27日
	 * @param userid
	 * @return
	 */
	List getUserBindBankList(long userid);
	/**
	 * 获取用户绑定的店铺信息
	 * @author wangjian
	 * @time 2016年7月28日
	 * @param userid
	 * @return
	 */
	List getUserBindShopList(long userid);
	/**
	 * 统计短信发送
	 * @author Administrator
	 * 2016年7月28日
	 * @param userid
	 * @param mobile
	 * @return
	 */
	int countSmsSendNum(long userid, long mobile);
	/**
	 * 短信发送列表
	 * @author Administrator
	 * 2016年7月28日
	 * @param userid
	 * @param mobile
	 * @return
	 */
	List getSmsSendList(long userid, long mobile, int firstPage, int pageSize);
	/**
	 * 资金流水
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param type 1.本金，2.佣金，3.冻结金
	 * @param search 搜索关键词
	 * @return
	 */
	int countMoneyDetailNum(long userid, int type, String search);
	/**
	 * 资金流水信息
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param type 1.本金，2.佣金，3.冻结金
	 * @param search  搜索关键词
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getMoenyDetaulLst(long userid, int type, String search, int firstPage, int pageSize);
	
	void testTransaction();
}
