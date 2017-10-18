package com.manage.service;

import java.util.List;
import java.util.Map;

import com.manage.model.Function;
import com.manage.model.FunctionGroup;

public interface FunctionService {
	/**
	 * 获取所有功能数
	 */
	int countAllFuncNum();
	/**
	 * 获取所有功能
	 * @return
	 */
	List<Function> getAllFunction(int firstPage, int pageSize);
	/**
	 * 获取所有功能组
	 * @return
	 */
	List<FunctionGroup> getAllFuncGroup();
	/**
	 * 添加新功能
	 * @param fn
	 * @return
	 */
	boolean addFunction(Function fn);
	/**
	 * 修改功能
	 * @param fn
	 * @return
	 */
	boolean reviseFunction(Function fn);
	/**
	 * 删除功能
	 * @param f_id
	 * @return
	 */
	boolean delFunction(int f_id);
	/**
	 * 获取功能信息
	 * @param f_id
	 * @return
	 */
	Function getFunctionByFid(int f_id);
	/**
	 * 功能是否已经分配给管理员
	 * @param f_id
	 * @return
	 */
	boolean funcIsGranted(int f_id);
	/**
	 * 功能组id获取功能组
	 * @author wangjian
	 * @time 2016年7月21日
	 * @param g_id
	 * @return
	 */
	FunctionGroup getFuncGroupByGid(int g_id);
	/**
	 * 添加功能组
	 * @author wangjian
	 * @time 2016年7月21日
	 * @param fg
	 * @return
	 */
	boolean addFuncGroup(FunctionGroup fg);
	/**
	 * 修改功能组
	 * @author wangjian
	 * @time 2016年7月21日
	 * @param fg
	 * @return
	 */
	boolean reviseFuncGroup(FunctionGroup fg);
	/**
	 * 删除功能组
	 * @author wangjian
	 * @time 2016年7月21日
	 * @param g_id
	 * @return
	 */
	boolean delFuncGroup(int g_id);
	/**
	 * 群组是否包含功能
	 * @author wangjian
	 * @time 2016年7月21日
	 * @param g_id
	 * @return
	 */
	boolean groupIsContainFunc(int g_id);
	/**
	 * 获取功能已分配管理员信息列表
	 * @author Administrator
	 * 2016年7月22日
	 * @param f_id
	 * @return
	 */
	List<Map<String, Object>> getFuncGrantMasterList(int f_id);
	/**
	 * 获取功能未已分配管理员信息列表
	 * @author Administrator
	 * 2016年7月22日
	 * @param f_id
	 * @return
	 */
	List<Map<String, Object>> getFuncUngrantMasterList(int f_id);
	/**
	 * 授予管理员权限
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id 管理员id
	 * @param f_id 功能id
	 * @param admin 授予管理员
	 * @return
	 */
	boolean grantMasterFunction(int m_id, int f_id, String admin);
	/**
	 * 回收管理员权限
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id
	 * @param f_id
	 * @return
	 */
	boolean recoverMasterFunction(int m_id, int f_id);
}
