package com.manage.service;

public interface SysService {
	/**
	 * 添加管理员登录日志
	 * @param m_id 管理员id
	 * @param ip 登录ip
	 * @return
	 */
	boolean addLoginLog(int m_id, String ip);
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
	boolean addVisiteLog(int m_id, String m_name, String url, String ip);
	
	void testTransaction();
}
