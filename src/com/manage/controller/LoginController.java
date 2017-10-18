package com.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.CodeStatus;
import com.common.IPTool;
import com.common.MD5;
import com.manage.dto.MasterFunctionGroup;
import com.manage.model.Function;
import com.manage.model.Master;
import com.manage.service.MasterService;
import com.manage.service.SysService;

/**
 * 登录相关controller
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private MasterService masterservice;
	@Autowired
	private SysService sysservice;
	
	/**
	 * 登录页
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest req) {
		try {
			Master master = (Master) req.getSession().getAttribute("master");
			if (master != null) {
				req.getSession().removeAttribute("master");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "login";
	}
	/**
	 * 登录操作(ajax)
	 * @param name
	 * @param pwd
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/logindo", method=RequestMethod.POST)
	@ResponseBody
	public Map dologin(@RequestParam("name") String name, @RequestParam("pwd") String pwd, HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "参数缺失");
				return retmap;
			}
			String password = MD5.getMD5(pwd.getBytes());
			Master master = masterservice.doLoginMaster(name, password);
			if (master == null) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "用户名或密码错误");
				return retmap;
			}
			int m_status = master.getM_status();
			if (m_status != 0) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "账号异常");
				return retmap;
			}
			String ip = IPTool.getClientIP(req);
			sysservice.addLoginLog(master.getM_id(), ip);
			List<MasterFunctionGroup> leftnavlist = masterservice.getMasterActFunc(master.getM_id());
			List<Function> masterfunclist = masterservice.getMasterFuncList(master.getM_id());
			req.getSession().setAttribute("masterfunclist", masterfunclist);
			req.getSession().setAttribute("leftnavlist", leftnavlist);
			req.getSession().setAttribute("master", master);
			retmap.put("status", CodeStatus.SUCCESS);
			retmap.put("msg", "成功");
		} catch (Exception e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return dashboard();
	}
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}
}
