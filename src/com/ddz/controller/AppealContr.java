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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Page;
import com.common.StatusResult;
import com.ddz.service.AppealService;
import com.manage.model.Master;

@Controller
@RequestMapping(value="/appeal")
public class AppealContr {
	@Autowired
	private AppealService appealservice;
	/**
	 * 申诉列表
	 * @param orderid
	 * @param userid
	 * @param beuserid
	 * @param appeal_type
	 * @param status
	 * @param plat_join_status
	 * @param startdate
	 * @param enddate
	 * @param pageIndex
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String appealLst(@RequestParam(value="orderid", required=false, defaultValue="-1")long orderid,
			@RequestParam(value="userid", required=false, defaultValue="-1")long userid,
			@RequestParam(value="beuserid", required=false, defaultValue="-1")long beuserid,
			@RequestParam(value="appeal_type", required=false, defaultValue="-1")int appeal_type,
			@RequestParam(value="status", required=false, defaultValue="-1")int status,
			@RequestParam(value="plat_join_status", required=false, defaultValue="-1")int plat_join_status,
			@RequestParam(value="startdate", required=false)String startdate,
			@RequestParam(value="enddate", required=false)String enddate,
			@RequestParam(value="pageIndex", required=false, defaultValue="1")int pageIndex,
			@RequestParam(value="pageSize", required=false, defaultValue="20")int pageSize, Model model) {
		try {
			int total = appealservice.countAppealNum(orderid, userid, beuserid, appeal_type, 
					status, plat_join_status, startdate, enddate);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = appealservice.getAppealLst(orderid, userid, beuserid, appeal_type, status,
						plat_join_status, startdate, enddate, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
			if (orderid > -1) model.addAttribute("orderid", orderid);
			if (userid > -1) model.addAttribute("userid", userid);
			if (beuserid > -1) model.addAttribute("beuserid", beuserid);
			if (appeal_type > -1) model.addAttribute("appeal_type", appeal_type);
			if (status > -1) model.addAttribute("status", status);
			if (plat_join_status > -1) model.addAttribute("plat_join_status", plat_join_status);
			if (!StringUtils.isEmpty(startdate)) model.addAttribute("startdate", startdate);
			if (!StringUtils.isEmpty(enddate)) model.addAttribute("enddate", enddate);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "appeal/list";
	}
	/**
	 * 申诉回复
	 * @return
	 */
	@RequestMapping(value="/echo")
	@ResponseBody
	public Map backAppeal(@RequestParam(value="orderid")long orderid,
			@RequestParam(value="isflow")int isflow, 
			@RequestParam(value="content")String content,
			HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			Master master = (Master) req.getSession().getAttribute("master");
			Map map = appealservice.backAppeal(orderid, isflow, master.getM_name(), content);
			if (map == null) {
				retmap.put("msg", "回复出错");
				return retmap;
			}
			retmap.put("status", map.get("o_result"));
			retmap.put("msg", map.get("o_msg"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 完结申诉
	 * @param orderid
	 * @param isflow
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/over")
	@ResponseBody
	public Map overAppeal(@RequestParam(value="orderid")long orderid,
			@RequestParam(value="isflow")int isflow, HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.putAll(StatusResult.ERROR.getRetMap());
		try {
			Master master = (Master) req.getSession().getAttribute("master");
			if (appealservice.overAppeal(orderid, isflow, master.getM_name())) {
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
	 * 申诉对话内容
	 * @param orderid
	 * @param isflow
	 * @return
	 */
	@RequestMapping(value="/list/detail")
	public String contentLst(@RequestParam(value="orderid")long orderid,
			@RequestParam(value="isflow")int isflow, Model model) {
		try {
			Map map = appealservice.getAppealMain(orderid, isflow);
			List list = appealservice.getAppealContent(orderid, isflow);
			model.addAttribute("dialoglist", list);
			model.addAttribute("appealmain", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "appeal/content";
	}
}
