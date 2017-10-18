package com.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.manage.model.Master;

@Component
public interface MasterDao {
	/**
	 * 冻结或解冻管理员
	 * @author wangjian
	 * @time 2016年7月20日
	 * @param m_id 管理员id
	 * @param m_status 0.正常
	 * @return
	 */
	int freezeOrUnfreezeMaster(@Param("m_id") int m_id, @Param("m_status") int m_status);
	/**
	 * 用户名密码登录
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param name
	 * @param pwd
	 * @return
	 */
	Master getMasterByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
	/**
	 * id获取管理员
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param id 管理员id
	 * @return
	 */
	Master getMasterById(int id);
	/**
	 * 获取所有管理员
	 * @return
	 */
	List<Master> getAllMaster();
	/**
	 * 添加管理员
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param master
	 */
	int addMaster(Master master);
	/**
	 * 更新管理员信息
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param master
	 * @return
	 */
	int updateMaster(Master master);
	/**
	 * 删除管理员
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param m_id 管理员id
	 */
	int delMaster(int m_id);
	/**
	 * 授予管理员功能权限
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param m_id 管理员id
	 * @param f_id 功能id
	 * @param admin 授予管理员
	 * @return
	 */
	int grantMasterFunc(@Param("m_id") int m_id, @Param("f_id") int f_id, @Param("admin") String admin);
	/**
	 * 移除管理员功能权限
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param m_id 管理员id
	 * @param f_id 功能id
	 * @return
	 */
	int removeMasterFunc(@Param("m_id") int m_id, @Param("f_id") int f_id);
	/**
	 * 获得管理员已经拥有的功能
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id 管理员id
	 * @return
	 */
	List<Map<String, Object>> getMasterHasFunctions(int m_id);
	/**
	 * 获取管理员未拥有的功能
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id 管理员id
	 * @return
	 */
	List<Map<String, Object>> getMastetNotHasFunctions(int m_id);
	/**
	 * 移除管理员下面的所有功能
	 * @author wangjian
	 * @time 2016年7月24日
	 * @param m_id
	 * @return
	 */
	int removeMasterAllFunc(int m_id);
}
