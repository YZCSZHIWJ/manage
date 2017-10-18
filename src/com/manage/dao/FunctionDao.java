package com.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.manage.model.Function;
import com.manage.model.FunctionGroup;

@Component
public interface FunctionDao {
	/**
	 * 获取用户分配的功能
	 * @author wangjian
	 * @time 2016年7月17日
	 * @param m_id
	 * @return
	 */
	List<Function> getMasterOwnerFunction(int m_id);
	/**
	 * 获取所有功能数目
	 * @return
	 */
	int countAllFuncNum();
	/**
	 * 获取所有功能
	 * @return
	 */
	List<Function> getAllFunction(@Param("firstPage") int firstPage, @Param("pageSize") int pageSize);
	/**
	 * fid获取功能
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param f_id
	 * @return
	 */
	Function getFuncByFid(int f_id);
	/**
	 * 获取所有功能组
	 * @return
	 */
	List<FunctionGroup> getAllFuncGroup();
	/**
	 * gid获取功能组
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param g_id
	 * @return
	 */
	FunctionGroup getFuncGroupByGid(int g_id);
	/**
	 * 添加功能组
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param fg
	 * @return
	 */
	int addFuncGroup(FunctionGroup fg);
	/**
	 * 修改功能组
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param fg
	 * @return
	 */
	int updateFuncGroup(FunctionGroup fg);
	/**
	 * 删除功能组
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param g_id
	 * @return
	 */
	int delFuncGroup(int g_id);
	/**
	 * 添加功能
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param func
	 * @return
	 */
	int addFunc(Function func);
	/**
	 * 修改功能
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param func
	 * @return
	 */
	int updateFunc(Function func);
	/**
	 * 删除功能
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param f_id
	 * @return
	 */
	int delFunc(int f_id);
	/**
	 * 功能已分配管理员数
	 * @return
	 */
	int funGrantMasterNum(int f_id);
	/**
	 * 功能组拥有的功能数
	 * @author wangjian
	 * @time 2016年7月21日
	 * @param g_id
	 * @return
	 */
	int groupHasFuncNum(int g_id);
	/**
	 * 获取功能授权管理员列表
	 * @author Administrator
	 * 2016年7月22日
	 * @param f_id
	 * @return
	 */
	List<Map<String, Object>> getFuncGrantMasteres(int f_id);
	/**
	 * 获取功能还未授权管理员列表
	 * @author Administrator
	 * 2016年7月22日
	 * @param f_id
	 * @return
	 */
	List<Map<String, Object>> getFuncUnGrantMasteres(int f_id);
	/**
	 * 授予管理员功能呢
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id 管理员id
	 * @param f_id 功能id
	 * @param admin 授予管理员
	 * @return
	 */
	int grantMasterFunc(@Param("m_id")int m_id, @Param("f_id")int f_id, @Param("admin")String admin);
	/**
	 * 
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id 管理员id
	 * @param f_id 功能id
	 * @return
	 */
	int recoverMasterFunc(@Param("m_id")int m_id, @Param("f_id")int f_id);
}
