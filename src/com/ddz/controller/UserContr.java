package com.ddz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Page;
import com.ddz.model.Account;
import com.ddz.model.User;
import com.ddz.service.UserService;

/**
 * 用户管理
 * @author Administrator
 */
@Controller
@RequestMapping("/user")
public class UserContr {
	@Autowired
	private UserService userservice;
	/**
	 * 用户详情
	 * @author wangjian
	 * @time 2016年7月26日
	 * @param req
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public String detail(HttpServletRequest req) {
		try {
			String userid = req.getParameter("userid");
			String mobile = req.getParameter("mobile");
			User user = null;
			if (!StringUtils.isEmpty(userid)) {
				userid = userid.trim();
				req.setAttribute("userid", userid);
				user = userservice.getUserById(Long.parseLong(userid));
			}
			if (user == null && !StringUtils.isEmpty(mobile)) {
				mobile = mobile.trim();
				req.setAttribute("mobile", mobile);
				user = userservice.getUserByMobile(Long.parseLong(mobile));
			}
			if (user == null) {
				return "user/userdetail";
			}
			req.setAttribute("user", user);
			Account account = userservice.getUserAccountById(user.getUserid());
			req.setAttribute("account", account);
			List bindbuyerlist = userservice.getUserBindList(user.getUserid());
			req.setAttribute("bindbuyerlist", bindbuyerlist);
			List bindbanklist = userservice.getUserBindBankList(user.getUserid());
			req.setAttribute("bindbanklist", bindbanklist);
			List bindshoplist = userservice.getUserBindShopList(user.getUserid());
			req.setAttribute("bindshoplist", bindshoplist);
		} catch (NumberFormatException e) {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "user/userdetail";
	}
	/**
	 * 短信发送查询
	 * @author Administrator
	 * 2016年7月28日
	 * @return
	 */
	@RequestMapping(value="/smsend", method=RequestMethod.GET)
	public String smsend(HttpServletRequest req) {
		try {
			String userid = req.getParameter("userid");
			String mobile = req.getParameter("mobile");
			String pageIndex = req.getParameter("pageIndex");
			String pageSize = req.getParameter("pageSize");
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
			if (StringUtils.isEmpty(mobile)) {
				mobile = "-1";
			} else {
				mobile = mobile.trim();
				req.setAttribute("mobile", mobile);
			}
			int total = userservice.countSmsSendNum(Long.parseLong(userid), Long.parseLong(mobile));
			Page page = new Page(Integer.parseInt(pageIndex), total, Integer.parseInt(pageSize));
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = userservice.getSmsSendList(Long.parseLong(userid), Long.parseLong(mobile), page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			req.setAttribute("page", page);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/smsend";
	}
	/**
	 * 用户资金流水明细
	 * @author Administrator
	 * 2016年8月10日
	 * @param userid
	 * @param search
	 * @param type 1.本金，2.佣金，3.冻结金
	 * @param model
	 * @return
	 */
	@RequestMapping(value="moneydetail")
	public String moneyDetail(@RequestParam(value="userid")long userid, 
			@RequestParam(value="search", required=false, defaultValue="")String search, 
			@RequestParam(value="type", required=false, defaultValue="1") int type,
			@RequestParam(value="pageIndex", required=false, defaultValue="1")int pageIndex, 
			@RequestParam(value="pageSize", required=false, defaultValue="20")int pageSize, Model model) {
		try {
			int total = userservice.countMoneyDetailNum(userid, type, search);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = userservice.getMoenyDetaulLst(userid, type, search, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
			model.addAttribute("userid", userid);
			model.addAttribute("type", type);
			model.addAttribute("search", search);
			String detailtype = "";
			switch (type) {
				case 1: detailtype = "本金流水";break;
				case 2: detailtype = "佣金流水";break;
				case 3: detailtype = "冻结金流水";break;
			}
			model.addAttribute("detailtype", detailtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/moneydetail";
	}
}
