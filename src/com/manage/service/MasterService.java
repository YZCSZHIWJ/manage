package com.manage.service;

import java.util.List;
import java.util.Map;

import com.manage.dto.MasterFunctionGroup;
import com.manage.model.Function;
import com.manage.model.Master;

public interface MasterService {
	/**
	 * 登录获取管理员用户
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param name
	 * @param pwd
	 * @return
	 */
	Master doLoginMaster(String name, String pwd);
	/**
	 * 获取管理员开通的功能及组，构建侧栏导航菜单
	 * @param m_id 管理员id
	 * @return
	 */
	List<MasterFunctionGroup> getMasterActFunc(int m_id);
	/**
	 * 获取管理员功能列表
	 * @param m_id 管理员id
	 * @return
	 */
	List<Function> getMasterFuncList(int m_id);
	/**
	 * 获取所有管理员
	 * @return
	 */
	List<Master> getAllMaster();
	/**
	 * 删除管理员
	 * @author wangjian
	 * @time 2016年7月20日
	 * @param m_id 管理员id
	 * @return
	 */
	boolean delMaster(int m_id);
	/**
	 * 修改管理员状态信息
	 * @author wangjian
	 * @time 2016年7月20日
	 * @param m_id 管理员id
	 * @param m_status 0.正常
	 * @return
	 */
	boolean upMasterStatus(int m_id, int m_status);
	/**
	 * 添加管理员
	 * @author wangjian
	 * @time 2016年7月20日
	 * @param master
	 * @return
	 */
	boolean addMaster(Master master);
	/**
	 * 获取管理员
	 * @param m_id 管理员id
	 * @return
	 */
	Master getMasterByMid(int m_id);
	/**
	 * 修改管理员资料
	 * @param master
	 * @return
	 */
	boolean reviseMaster(Master master);
	/**
	 * 管理员已授权功能列表
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id
	 * @return
	 */
	List<Map> grantedFuncList(int m_id);
	/**
	 * 管理员未授权功能列表
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id
	 * @return
	 */
	List<Map> ungrantFuncList(int m_id);
	
}
