package com.ddz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ddz.model.Account;
import com.ddz.model.User;

@Repository
public interface UserDao {
	/**
	 * 用户id获取用户
	 * @param userid
	 * @return
	 */
	User getUserByUserid(long userid);
	/**
	 * 手机号获取用户
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
	Account getUserAccount(long userid);
	/**
	 * 获取用户绑定的第三方账号列表信息
	 * @author wangjian
	 * @time 2016年7月27日
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> getUserBindList(long userid);
	/**
	 * 获取用户绑定银行账号信息
	 * @author wangjian
	 * @time 2016年7月27日
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> getUserBindBankList(long userid);
	/**
	 * 获取用户绑定店铺信息
	 * @author wangjian
	 * @time 2016年7月27日
	 * @param userid
	 * @return
	 */
	List<Map<String, Object>> getUserBindShopList(long userid);	
	/**
	 * 统计短信发送数
	 * @author Administrator
	 * 2016年7月28日
	 * @param param
	 * @return
	 */
	int countSmsSendNum(Map param);
	/**
	 * 短信发送查询信息
	 * @author Administrator
	 * 2016年7月28日
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getSmsSendList(Map param);
	/**
	 * 统计本金流水数
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search 
	 * @return
	 */
	int countMoneyDetailNum(@Param("userid")long userid, @Param("search")String search);
	/**
	 * 获取本金流水信息
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search
	 * @return
	 */
	List getMoenyDetailLst(@Param("userid")long userid, @Param("search")String search, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 获取佣金流水数
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search
	 * @return
	 */
	int countGoldDetailNum(@Param("userid")long userid, @Param("search")String search);
	/**
	 * 获取佣金流水信息
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search
	 * @return
	 */
	List getGoldDetailLst(@Param("userid")long userid, @Param("search")String search, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 获取冻结金流水数
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search
	 * @return
	 */
	int countFmoneyDetailNum(@Param("userid")long userid, @Param("search")String search);
	/**
	 * 获取冻结金流水信息
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search
	 * @return
	 */
	List getFmoneyDetailLst(@Param("userid")long userid, @Param("search")String search, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	
	int addTest1(@Param("name")String name, @Param("age")int age);
	
	int addTest2(String address);
}
