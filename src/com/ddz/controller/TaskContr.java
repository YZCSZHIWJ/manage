package com.ddz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Page;
import com.ddz.service.TaskService;
import com.ddz.service.UserService;

@Controller
@RequestMapping("/task")
public class TaskContr {
	@Autowired
	private UserService userservice;
	@Autowired
	private TaskService taskservice;
	/**
	 * 浏览任务列表
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @param userid
	 * @param plat
	 * @param progress 任务进度，-1.全部，0.未接单， 1.待操作，2.待确认，3.已完成
	 * @return
	 */
	@RequestMapping(value="/flowlist")
	public String flowTaskLst(@RequestParam(value="id", required=false, defaultValue="-1")long id, 
			@RequestParam(value="userid", required=false, defaultValue="-1")long userid, 
			@RequestParam(value="plat", required=false, defaultValue="-1")int plat,
			@RequestParam(value="progress", required=false, defaultValue="-1")int progress,
			@RequestParam(value="pageIndex", required=false, defaultValue="1") int pageIndex,
			@RequestParam(value="pageSize", required=false, defaultValue="20") int pageSize, Model model) {
		try {
			int total = taskservice.countAuditedFlowTaskNum(id, userid, plat, progress);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = taskservice.getAuditedFlowTaskLst(id, userid, plat, progress, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
			if (id > -1) model.addAttribute("id", id);
			if (userid > -1) model.addAttribute("userid", userid);
			if (plat > -1) model.addAttribute("plat", plat);
			if (progress > -1) model.addAttribute("progress", progress);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "task/flowlist";
	}
	
	/**
	 * 浏览任务详情
	 * @author Administrator
	 * 2016年8月11日
	 * @param id
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/flowlist/detail")
	public String flowTaskDetail(@RequestParam(value="id", required=false, defaultValue="-1")long id, Model model) {
		try {
			Map detail = taskservice.getFlowTaskDetail(id);
			if (detail == null) {
				return "task/flowdetail";
			}
			Map limit = taskservice.getFlowTaskLimit(id);
			Map payinfo = taskservice.getFlowTaskPay(id);
			Map timeset = taskservice.getFlowTaskTimeset(id);
			List keywordes = taskservice.getFlowTaskKeywordes(id);
			model.addAttribute("detail", detail);
			model.addAttribute("limit", limit);
			model.addAttribute("payinfo", payinfo);
			model.addAttribute("timeset", timeset);
			model.addAttribute("keywordes", keywordes);
			model.addAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "task/flowdetail";
	}
}
