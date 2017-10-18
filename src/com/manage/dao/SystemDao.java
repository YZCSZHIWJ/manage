package com.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SystemDao {
	/**
	 * 添加登录日志
	 * @param m_id 管理员id
	 * @param ip 登录ip
	 * @return
	 */
	int addLoginLog(@Param("m_id") int m_id, @Param("ip") String ip);
	/**
	 * 添加访问日志
	 * @author wangjian
	 * @time 2016年7月24日
	 * @param m_id
	 * @param m_name
	 * @param url
	 * @param ip
	 * @return
	 */
	int addVisiteLog(@Param("m_id")int m_id, @Param("m_name")String m_name, @Param("url")String url, @Param("ip")String ip);
	/**
	 * 管理员登录日志信息
	 * @author wangjian
	 * @time 2016年7月25日
	 * @param m_id 管理员id
	 * @return
	 */
	List<Map> getMasterLoginLogList(Map param);
	
	int addToTestTb(String name);
}
