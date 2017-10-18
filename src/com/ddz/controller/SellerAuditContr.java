package com.ddz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Page;
import com.common.StatusResult;
import com.ddz.service.AuditService;
import com.manage.model.Master;

@Controller
@RequestMapping(value="/selleraudit")
public class SellerAuditContr {
	@Autowired
	private AuditService auditservice;
	
	/**
	 * 商家店铺绑定审核
	 * @author wangjian
	 * @time 2016年8月9日
	 * @return
	 */
	@RequestMapping(value="/shoplist")
	public String bindShopList(HttpServletRequest req) {
		try {
			String userid = req.getParameter("userid");
			String shopname = req.getParameter("shopname");
			String plat = req.getParameter("plat");//1.淘宝，2.天猫，3.京东
			String status = req.getParameter("status"); //状态 0 待审核，1.审核通过，2.不通过,3.冻结
			String pageIndex = req.getParameter("pageIndex");
			String pageSize = req.getParameter("pageSize");
			if (StringUtils.isEmpty(userid)) {
				userid = "-1";
			} else {
				userid = userid.trim();
				req.setAttribute("userid", userid);
			}
			if (!StringUtils.isEmpty(shopname)) {
				shopname = shopname.trim();
				req.setAttribute("shopname", shopname);
			}
			if (StringUtils.isEmpty(plat)) {
				plat = "-1";
			}
			if (StringUtils.isEmpty(status)) {
				status = "0";
			}
			if (StringUtils.isEmpty(pageIndex)) {
				pageIndex = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "20";
			}
			int total = auditservice.countBindShopNum(Long.parseLong(userid), shopname, Integer.parseInt(plat), Integer.parseInt(status));
			Page page = new Page(Integer.parseInt(pageIndex), total, Integer.parseInt(pageSize));
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = auditservice.getBindShopLst(Long.parseLong(userid), shopname, Integer.parseInt(plat), 
						Integer.parseInt(status), page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			req.setAttribute("page", page);
			req.setAttribute("plat", plat);
			req.setAttribute("status", status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "selleraudit/shoplist";
	}
	/**
	 * 审核店铺操作(ajax)
	 * @author wangjian
	 * @time 2016年8月9日
	 * @param id 绑定id
	 * @param userid 用户id
	 * @param status 状态, 1.通过, 2.拒绝
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/auditshop", method=RequestMethod.POST)
	@ResponseBody
	public Map auditShop(@RequestParam("id")long id, @RequestParam("userid")long userid, @RequestParam("status")int status,
			@RequestParam(value="reason", required=false)String reason, HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			if (status == 2 && StringUtils.isEmpty(reason)) {
				retmap.put("msg", "请填写拒绝原因");
				return retmap;
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (auditservice.auditShop(id, userid, status, reason, master.getM_name())) {
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
	 * 浏览任务审核页
	 * @author wangjian
	 * @time 2016年8月10日
	 * @param id 任务id
	 * @param userid 商家id
	 * @param plat 1.淘宝，2.天猫，3.京东
	 * @param status 任务状态  0.未审核，1.已审核，2.已完成，3.不通过，4.被冻结
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/flowtasklst")
	public String auditFlowTaskPage(@RequestParam(value="id", required=false, defaultValue="-1") long id, 
			@RequestParam(value="userid", required=false, defaultValue="-1") long userid, 
			@RequestParam(value="plat", required=false, defaultValue="-1") int plat,
			@RequestParam(value="status", required=false, defaultValue="0") int status,
			@RequestParam(value="pageIndex", required=false, defaultValue="1") int pageIndex,
			@RequestParam(value="pageSize", required=false, defaultValue="20") int pageSize, Model model) {
		try {
			int total = auditservice.countFlowTaskNum(id, userid, status, plat);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = auditservice.getFlowTaskLst(id, userid, status, plat, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
			if (id > -1) {
				model.addAttribute("id", id);
			}
			if (userid > -1) {
				model.addAttribute("userid", userid);
			}
			if (plat > -1) {
				model.addAttribute("plat", plat);
			}
			if (status > -1) {
				model.addAttribute("status", status);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "selleraudit/flowtasklst";
	}
	/**
	 * 审核浏览任务(ajax)
	 * @author Administrator
	 * 2016年8月10日
	 * @param id
	 * @param userid 
	 * @param status 1.通过，3，拒绝
	 * @param reason 拒绝原因
	 * @return
	 */
	@RequestMapping(value="/auditflowtask", method=RequestMethod.POST)
	@ResponseBody
	public Map auditFlowTask(@RequestParam(value="id")long id, @RequestParam(value="userid")long userid, 
			@RequestParam(value="status")int status, @RequestParam(value="reason", required=false)String reason,
			HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			if (status == 3 && StringUtils.isEmpty(reason)) {
				retmap.put("msg", "请填写拒绝原因");
				return retmap;
			}
			Master master = (Master)req.getSession().getAttribute("master");
			Map map = auditservice.auditFlowTask(id, userid, status, reason, master.getM_name());
			if (map == null) {
				retmap.put("msg", "审核出错");
				return retmap;
			}
			retmap.put("status", map.get("o_result"));
			retmap.put("o_msg", map.get("o_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retmap;
	}
}
