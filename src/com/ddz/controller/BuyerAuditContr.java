package com.ddz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Page;
import com.common.StatusResult;
import com.ddz.service.AuditService;
import com.manage.model.Master;

@Controller
@RequestMapping("/buyeraudit")
public class BuyerAuditContr {
	@Autowired
	private AuditService auditservice;
	/**
	 * 身份证审核列表页
	 * @author wangjian
	 * @time 2016年8月3日
	 * @return
	 */
	@RequestMapping(value="/idcardlst")
	public String idCardList(HttpServletRequest req) {
		try {
			String userid = req.getParameter("userid");
			String cname = req.getParameter("cname");
			String cardno = req.getParameter("cardno");
			String pageIndex = req.getParameter("pageIndex");
			String pageSize = req.getParameter("pageSize");
			String status = req.getParameter("status"); //状态：-1.全部，0.待审核，1.审核通过，2.审核拒绝 	
			if (StringUtils.isEmpty(pageIndex)) {
				pageIndex = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "20";
			}
			if (StringUtils.isEmpty(userid)) {
				userid = "-1";
			} else {
				userid = userid.trim();
				req.setAttribute("userid", userid);
			}
			if (!StringUtils.isEmpty(cname)) {
				cname = cname.trim();
				req.setAttribute("cname", cname);
			}
			if (!StringUtils.isEmpty(cardno)) {
				cardno = cardno.trim();
				req.setAttribute("cardno", cardno);
			}
			if (StringUtils.isEmpty(status)) {
				status = "0";
			}
			int total = auditservice.countAuditIdCardNum(Long.valueOf(userid), cname, cardno, Integer.parseInt(status));
			Page page = new Page(Integer.parseInt(pageIndex), total, Integer.parseInt(pageSize));
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = auditservice.getAuditIdCardLst(Long.parseLong(userid), cname, cardno, 
						Integer.parseInt(status), page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			req.setAttribute("page", page);
			req.setAttribute("status", status);
		} catch(NumberFormatException e) {
			return "audit/idcard";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "buyeraudit/idcard";
	}
	/**
	 * 身份证审核操作(ajax)
	 * @author wangjian
	 * @time 2016年8月4日
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/idcardaudit")
	@ResponseBody
	public Map doAuditIdCard(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			String userid = req.getParameter("userid");
			String status = req.getParameter("status");//1.通过，2.拒绝
			String reason = req.getParameter("reason");//拒绝原因
			if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(status)
					|| (status.equals("2") && StringUtils.isEmpty(reason))) {
				return StatusResult.NEEDPARAM.getRetMap();
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			if (auditservice.auditIdCard(Long.parseLong(userid), Integer.parseInt(status), reason, master.getM_name())) {
				return StatusResult.SUCCESS.getRetMap();
			} else {
				return StatusResult.FAILED.getRetMap();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 账号审核列表页
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param accplat 1.淘宝，3.京东
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/accauditlst/{accplat}")
	public String accAuditList(@PathVariable("accplat") int plat, HttpServletRequest req) {
		try {
			String userid = req.getParameter("userid");
			String status = req.getParameter("status"); // 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
			String pageIndex = req.getParameter("pageIndex");
			String pageSize = req.getParameter("pageSize");
			
			if (StringUtils.isEmpty(userid)) {
				userid = "-1";
			} else {
				userid = userid.trim();
				req.setAttribute("userid", userid);
			}
			if (StringUtils.isEmpty(status)) {
				status = "0";
			}
			req.setAttribute("status", status);
			if (StringUtils.isEmpty(pageIndex)) {
				pageIndex = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "20";
			}
 			int total = auditservice.countBuyerAccNum(plat, Long.parseLong(userid), Integer.parseInt(status));
			Page page = new Page(Integer.parseInt(pageIndex), total, Integer.parseInt(pageSize));
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = auditservice.getBuyerAccLst(plat, Long.parseLong(userid), Integer.parseInt(status),
						page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			req.setAttribute("page", page);
			String platname = "";
			switch (plat) {
				case 1: 
				case 2: platname = "淘宝号";break;
				case 3: platname = "京东号";break;
			}
			req.setAttribute("platname", platname);
			req.setAttribute("plat", plat);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "buyeraudit/accauditlist";
	}
	/**
	 * 审核买手绑定的账号操作(ajax)
	 * @author wangjian
	 * @time 2016年8月8日
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/auditacc", method=RequestMethod.POST)
	@ResponseBody
	public Map auditAcc(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			String id = req.getParameter("id");//绑定的id
			String userid = req.getParameter("userid");//买手id
			String status = req.getParameter("status");//状态 0.待审核，1.审核通过，2.拒绝，3.禁用
			String reason = req.getParameter("reason");//拒绝原因
			if (StringUtils.isEmpty(id) || StringUtils.isEmpty(userid) || StringUtils.isEmpty(status)
					|| (status.equals("2") && StringUtils.isEmpty(reason))) {
				return StatusResult.NEEDPARAM.getRetMap();
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			if (auditservice.auditBuyerBindAcc(Long.parseLong(id), Long.parseLong(userid), 
					Integer.parseInt(status), reason, master.getM_name())) {
				return StatusResult.SUCCESS.getRetMap();
			} else {
				return StatusResult.FAILED.getRetMap();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 买手绑定花呗审核页
	 * @author Administrator
	 * 2016年8月9日
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/hbauditlst")
	public String hbAuditList(HttpServletRequest req) {
		try {
			String userid = req.getParameter("userid");
			String status = req.getParameter("status"); // 账号审核状态：0.待审核，1.审核通过，2.拒绝，3.禁用
			String hb_status = req.getParameter("hb_status"); //花呗状态 0.未提交，1.待审核，2.通过，3.不通过
			String pageIndex = req.getParameter("pageIndex");
			String pageSize = req.getParameter("pageSize");
			if (StringUtils.isEmpty(userid)) {
				userid = "-1";
			} else {
				userid = userid.trim();
				req.setAttribute("userid", userid);
			}
			if (StringUtils.isEmpty(status)) {
				status = "1";
			}
			req.setAttribute("status", Integer.parseInt(status));
			if (StringUtils.isEmpty(hb_status)) {
				hb_status = "1";
			}
			req.setAttribute("hb_status", Integer.parseInt(hb_status));
			if (StringUtils.isEmpty(pageIndex)) {
				pageIndex = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "20";
			}
			int total = auditservice.countAuditHbNum(Long.parseLong(userid), Integer.parseInt(status), Integer.parseInt(hb_status));
			Page page = new Page(Integer.parseInt(pageIndex), total, Integer.parseInt(pageSize));
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = auditservice.getAuditHbLst(Long.parseLong(userid), Integer.parseInt(status), Integer.parseInt(hb_status),
						page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			req.setAttribute("page", page);
			req.setAttribute("status", status);
			req.setAttribute("hb_status", hb_status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "buyeraudit/hbauditlist";
	}
	/**
	 * 审核买手绑定的花呗操作(ajax)
	 * @author Administrator
	 * 2016年8月9日
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/audithb", method=RequestMethod.POST)
	@ResponseBody
	public Map auditHb(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			String id = req.getParameter("id");
			String userid = req.getParameter("userid");
			String hb_status = req.getParameter("hb_status");
			String reason = req.getParameter("reason");
			if (StringUtils.isEmpty(id) || StringUtils.isEmpty(userid) || StringUtils.isEmpty(hb_status)
					|| (hb_status.equals("3") && StringUtils.isEmpty(reason))) {
				return StatusResult.NEEDPARAM.getRetMap();
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			if (auditservice.auditBuyerHb(Long.parseLong(id), Long.parseLong(userid), 
					Integer.parseInt(hb_status), reason, master.getM_name())) {
				return StatusResult.SUCCESS.getRetMap();
			} else {
				return StatusResult.FAILED.getRetMap();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retmap;
	}
	
}
