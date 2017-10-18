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
import com.ddz.service.OrderService;
import com.manage.model.Master;

@Controller
@RequestMapping("/order")
public class OrderContr {
	@Autowired
	private OrderService orderservice;
	/**
	 * 浏览订单查询
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 订单id
	 * @param tid 任务id
	 * @param userid  买手id
	 * @param sellerid 商家id
	 * @param account 买手买号
	 * @param plat 平台，1.淘宝，2.天猫，3.京东
	 * @param device 操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @param pageIndex 
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/flowlist")
	public String flowList(@RequestParam(value="id", required=false, defaultValue="-1")long id,
			@RequestParam(value="tid", required=false, defaultValue="-1")long tid,
			@RequestParam(value="userid", required=false, defaultValue="-1")long userid,
			@RequestParam(value="sellerid", required=false, defaultValue="-1")long sellerid,
			@RequestParam(value="account", required=false, defaultValue="")String account,
			@RequestParam(value="plat", required=false, defaultValue="-1")int plat,
			@RequestParam(value="device", required=false, defaultValue="-1")int device,
			@RequestParam(value="status", required=false, defaultValue="-1")int status,
			@RequestParam(value="pageIndex", required=false, defaultValue="1")int pageIndex,
			@RequestParam(value="pageSize", required=false, defaultValue="20")int pageSize, Model model) {
		try {
			int total = orderservice.countFlowOrderNum(id, tid, userid, sellerid, account, plat, device, status);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = orderservice.getFlowOrderLst(id, tid, userid, sellerid, account, plat, device, status, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
			if (id > -1) model.addAttribute("id", id);
			if (tid > -1) model.addAttribute("tid", tid);
			if (userid > -1) model.addAttribute("userid", userid);
			if (sellerid > -1) model.addAttribute("sellerid", sellerid);
			if (plat > -1) model.addAttribute("plat", plat);
			if (device > -1) model.addAttribute("device", device);
			if (status > -1) model.addAttribute("status", status);
			if (!StringUtils.isEmpty(account)) model.addAttribute("account", account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/floworderlist";
	}
	/**
	 * 浏览单详情
	 * @author Administrator
	 * 2016年8月25日
	 * @param id 订单id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/flowlist/detail")
	public String flowDetail(@RequestParam(value="id")long id, Model model) {
		try {
			Map detail = orderservice.getFlowOrderDetail(id);
			if (detail == null) {
				return "order/flowdetail";
			}
			model.addAttribute("id", id);
			model.addAttribute("detail", detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/flowdetail";
	}
	/**
	 * 撤销浏览单放给其他用户接手(ajax)
	 * @author Administrator
	 * 2016年8月25日
	 * @return
	 */
	@RequestMapping(value="/cancelflow", method=RequestMethod.POST)
	@ResponseBody
	public Map cancelFlowOrder(@RequestParam(value="id")long id, @RequestParam(value="userid")long userid, HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			String remark = "管理员撤销用户订单";
			Map map = orderservice.cancelFlowOrder(id, userid, remark, master.getM_name());
			if (map == null) {
				retmap.put("msg", "撤销操作出错");
				return retmap;
			}
			retmap.put("status", map.get("o_result"));
			retmap.put("msg", map.get("o_msg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retmap;
	}
	
	/**
	 * 已撤销浏览订单查询
	 * @author Administrator
	 * 2016年8月11日
	 * @param id 订单id
	 * @param tid 任务id
	 * @param userid  买手id
	 * @param sellerid 商家id
	 * @param account 买手买号
	 * @param plat 平台，1.淘宝，2.天猫，3.京东
	 * @param device 操作设备 1.手机，2.电脑
	 * @param status 状态 0.待操作，1.待确认，2.完成
	 * @param pageIndex 
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/canceledflowlist")
	public String canceledFlowOrderList(@RequestParam(value="id", required=false, defaultValue="-1")long id,
			@RequestParam(value="tid", required=false, defaultValue="-1")long tid,
			@RequestParam(value="userid", required=false, defaultValue="-1")long userid,
			@RequestParam(value="sellerid", required=false, defaultValue="-1")long sellerid,
			@RequestParam(value="account", required=false, defaultValue="")String account,
			@RequestParam(value="plat", required=false, defaultValue="-1")int plat,
			@RequestParam(value="device", required=false, defaultValue="-1")int device,
			@RequestParam(value="status", required=false, defaultValue="-1")int status,
			@RequestParam(value="pageIndex", required=false, defaultValue="1")int pageIndex,
			@RequestParam(value="pageSize", required=false, defaultValue="20")int pageSize, Model model) {
		try {
			if (id > -1) model.addAttribute("id", id);
			if (tid > -1) model.addAttribute("tid", tid);
			if (userid > -1) model.addAttribute("userid", userid);
			if (sellerid > -1) model.addAttribute("sellerid", sellerid);
			if (plat > -1) model.addAttribute("plat", plat);
			if (device > -1) model.addAttribute("device", device);
			if (status > -1) model.addAttribute("status", status);
			if (!StringUtils.isEmpty(account)) model.addAttribute("account", account);
			int total = orderservice.countCanceledFlowOrderNum(id, tid, userid, sellerid, account, plat, device, status);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = orderservice.getCanceledFlowOrderLst(id, tid, userid, sellerid, account, plat, device, status, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/canceledflowlist";
	}
	
	/**
	 * 已撤销的浏览单详情
	 * @author Administrator
	 * 2016年8月25日
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/canceledflowlist/detail")
	public String canceledFlowOrderDetail(@RequestParam(value="id", required=false, defaultValue="-1")long id, Model model) {
		try {
			Map detail = orderservice.getCanceledFlowOrderDetail(id);
			model.addAttribute("detail", detail);
			model.addAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/canceledflowdetail";
	}
}
