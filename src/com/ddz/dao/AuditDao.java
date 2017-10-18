package com.ddz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditDao {
	/**
	 * 身份证绑定统计
	 * @author wangjian
	 * @time 2016年8月3日
	 * @param userid 
	 * @param cname 姓名
	 * @param cardno 身份证号码
	 * @param status 状态：0.待审核，1.审核通过，2.审核拒绝 	
	 * @return
	 */
	int countAuditIDCardNum(@Param("userid")long userid, @Param("cname")String cname, @Param("cardno")String cardno, @Param("status")int status);
	/**
	 * 身份证绑定信息
	 * @author wangjian
	 * @time 2016年8月3日
	 * @param userid
	 * @param cname  姓名
	 * @param cardno  身份证号码
	 * @param status 状态：0.待审核，1.审核通过，2.审核拒绝 	
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List<Map> getAuditIDCardLst(@Param("userid")long userid, @Param("cname")String cname, @Param("cardno")String cardno,
			@Param("status")int status, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 审核身份证
	 * @author wangjian
	 * @time 2016年8月4日
	 * @param userid
	 * @param status 状态：0.待审核，1.审核通过，2.审核拒绝 	
	 * @param reason 拒绝原因
	 * @param admin 管理员
	 * @return
	 */
	int auditIdCard(@Param("userid")long userid, @Param("status")int status, @Param("reason")String reason, @Param("admin")String admin);
	/**
	 * 统计买手绑定账号数
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param plat 1.淘宝，3.京东
	 * @param userid 买手id -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @return
	 */
	int countAuditBuyerAccNum(@Param("plat")int plat, @Param("userid")long userid, @Param("status")int status);
	/**
	 * 买手绑定账号列表
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param plat 1.淘宝，3.京东
	 * @param userid 买手id -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getAuditBuyerAccLst(@Param("plat")int plat, @Param("userid")long userid, @Param("status")int status,
			@Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 审核买手绑定的买号
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param id 绑定id
	 * @param userid 买手id
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param reason 拒绝原因
	 * @param admin 审核管理员
	 * @return
	 */
	int auditBuyerBindAcc(@Param("id")long id, @Param("userid")long userid, @Param("status")int status,
			@Param("reason")String reason, @Param("admin")String admin);
	/**
	 * 统计买手绑定的花呗数
	 * @author Administrator
	 * 2016年8月9日
	 * @param userid 用户id, -1.全部用户
	 * @param status 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param hb_status 花呗状态 0.未提交，1.待审核，2.通过，3.不通过
	 * @return
	 */
	int countAuditHbNum(@Param("userid")long userid, @Param("status")int status, @Param("hb_status")int hb_status);
	/**
	 * 获取买手绑定的花呗列表
	 * @author Administrator
	 * 2016年8月9日
	 * @param userid 用户id, -1.全部用户
	 * @param status  账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
	 * @param hb_status 花呗状态 0.未提交，1.待审核，2.通过，3.不通过
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getAuditHbLst(@Param("userid")long userid, @Param("status")int status, @Param("hb_status")int hb_status, 
			@Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 审核买手绑定的花呗
	 * @author Administrator
	 * 2016年8月9日
	 * @param id
	 * @param userid
	 * @param hb_status 花呗状态 0.未提交，1.待审核，2.通过，3.不通过
	 * @param reason 拒绝理由
	 * @param admin 审核管理员
	 * @return
	 */
	int auditHb(@Param("id")long id, @Param("userid")long userid, @Param("hb_status")int hb_status,
			@Param("reason")String reason, @Param("admin")String admin);
	/**
	 * 统计商家绑定的店铺数目
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param userid -1.全部用户
	 * @param shopname 店铺名称
	 * @param plat 1.淘宝，2.天猫，3.京东
	 * @param status 状态 0.待审核，1.审核通过，2.不通过,3.冻结
	 * @return
	 */
	int countBindShopNum(@Param("userid")long userid, @Param("shopname")String shopname, @Param("plat")int plat, @Param("status")int status);
	/**
	 * 获取商家绑定的店铺信息
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param userid -1.全部用户
	 * @param shopname 店铺名称
	 * @param plat 1.淘宝，2.天猫，3.京东
	 * @param status 状态 0.待审核，1.审核通过，2.不通过,3.冻结
	 * @param firstPage
	 * @param pageSize
	 * @return
	 */
	List getBindShopLst(@Param("userid")long userid, @Param("shopname")String shopname, @Param("plat")int plat, 
			@Param("status")int status, @Param("firstPage")int firstPage, @Param("pageSize")int pageSize);
	/**
	 * 审核商家绑定的店铺操作
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param id 绑定id
	 * @param userid 商家id
	 * @param status 状态 0 待审核，1.审核通过，2.不通过,3.冻结
	 * @param reason 拒绝原因
	 * @param admin 审核管理员
	 * @return
	 */
	int auditBindShop(@Param("id")long id, @Param("userid")long userid, @Param("status")int status,
			@Param("reason")String reason, @Param("admin")String admin);
	/**
	 * 浏览任务审核
	 * @author Administrator
	 * 2016年8月10日
	 * @param map
	 */
	void auditFlowTask(Map map);
}
