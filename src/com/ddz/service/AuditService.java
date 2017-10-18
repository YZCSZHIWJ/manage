package com.ddz.service;

import java.util.List;
import java.util.Map;

public interface AuditService {
	/**
	 * 身份证号码审核统计
	 * @author wangjian
	 * @time 2016年8月3日
	 * @param userid
	 * @param cname 姓名
	 * @param idcardnum 身份证号码
	 * @param status 状态：0.待审核，1.审核通过，2.审核拒绝 	
	 * @return
	 */
	int countAuditIdCardNum(long userid, String cname, String idcardnum, int status);
	/**
	 * 身份证号码审核信息
	 * @author wangjian
	 * @time 2016年8月3日
	 * @param userid
	 * @param cname  姓名
	 * @param idcardnum  身份证号码
	 * @param status 状态：0.待审核，1.审核通过，2.审核拒绝 	
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List<Map> getAuditIdCardLst(long userid, String cname, String idcardnum, int status, int firstPage, int pageSize);
	
	/**
	 * 身份证审核操作
	 * @author wangjian
	 * @time 2016年8月4日
	 * @param userid
	 * @param status 状态：0.待审核，1.审核通过，2.审核拒绝 
	 * @param reason 拒绝原因
	 * @param admin 审核管理员
	 * @return
	 */
	boolean auditIdCard(long userid, int status, String reason, String admin);
	/**
	 * 统计买手账号数目
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param plat  1.淘宝，3.京东
	 * @param userid  买手id -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @return
	 */
	int countBuyerAccNum(int plat, long userid, int status);
	/**
	 * 买手绑定账号列表
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param plat 1.淘宝，2.京东
	 * @param userid 买手id -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @return
	 */
	List getBuyerAccLst(int plat, long userid, int status, int firstPage, int pageSize);
	/**
	 * 审核买手绑定的买号操作
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param id 绑定id
	 * @param userid 买手id 
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param reason 拒绝原因
	 * @param admin 审核管理员
	 * @return
	 */
	boolean auditBuyerBindAcc(long id, long userid, int status, String reason, String admin);
	/**
	 * 统计买手绑定的花呗数
	 * @author Administrator
	 * 2016年8月9日
	 * @param userid -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param hb_status 花呗状态 0.未提交，1.待审核，2.通过，3.不通过
	 * @return
	 */
	int countAuditHbNum(long userid, int status, int hb_status);
	/**
	 * 获取买手绑定的花呗列表数据
	 * @author Administrator
	 * 2016年8月9日
	 * @param userid -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param hb_status 花呗状态 0.未提交，1.待审核，2.通过，3.不通过
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getAuditHbLst(long userid, int status, int hb_status, int firstPage, int pageSize);
	/**
	 * 审核买手绑定的花呗操作
	 * @author Administrator
	 * 2016年8月9日
	 * @param id
	 * @param userid
	 * @param hb_status 花呗状态 0.未提交，1.待审核，2.通过，3.不通过
	 * @param reason 拒绝原因
	 * @param admin 操作管理员
	 * @return
	 */
	boolean auditBuyerHb(long id, long userid, int hb_status, String reason, String admin);
	/**
	 * 统计商家绑定的店铺数
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param userid -1.全部用户
	 * @param shopname 店铺名称
	 * @param plat 1.淘宝，2.天猫，3.京东
	 * @param status 状态 0.待审核，1.审核通过，2.不通过,3.冻结
	 * @return
	 */
	int countBindShopNum(long userid, String shopname, int plat, int status);
	/**
	 * 获取商家绑定的店铺列表
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param userid  -1.全部用户
	 * @param shopname  店铺名称
	 * @param plat  1.淘宝，2.天猫，3.京东
	 * @param status 状态 0.待审核，1.审核通过，2.不通过,3.冻结
	 * @param firstPage
	 * @param PageSize
	 * @return
	 */
	List getBindShopLst(long userid, String shopname, int plat, int status, int firstPage, int pageSize);
	/**
	 * 店铺审核操作
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param id 绑定id
	 * @param userid 商家id
	 * @param status 状态 0.待审核，1.审核通过，2.不通过,3.冻结 
	 * @param reason 拒绝原因
	 * @param admin 审核管理员
	 * @return
	 */
	boolean auditShop(long id, long userid, int status, String reason, String admin);
	/**
	 * 统计商家任务数
	 * @author wangjian
	 * @time 2016年8月10日
	 * @param id 任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param status 任务状态  0.未审核，1.已审核，2.已完成，3.不通过，4.被冻结
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @return
	 */
	int countFlowTaskNum(long id, long userid, int status, int plat);
	/**
	 * 获取商家发布的任务信息列表
	 * @author wangjian
	 * @time 2016年8月10日
	 * @param id  任务id -1.全部
	 * @param userid 商家id -1.全部
	 * @param status 任务状态  0.未审核，1.已审核，2.已完成，3.不通过，4.被冻结
	 * @param plat 操作平台，-1.全部，1.淘宝，2.天猫，3.京东
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getFlowTaskLst(long id, long userid, int status, int plat, int firstPage, int pageSize);
	/**
	 * 审核浏览任务
	 * @author Administrator
	 * 2016年8月10日
	 * @param id 任务id
	 * @param userid 商家id
	 * @param status 1.通过，3，拒绝
	 * @param reason 拒绝原因
	 * @param admin 审核管理员
	 * @return
	 */
	Map auditFlowTask(long id, long userid, int status, String reason, String admin);
}
