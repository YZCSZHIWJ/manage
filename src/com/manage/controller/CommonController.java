package com.manage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.CodeStatus;
import com.common.MD5;
import com.manage.model.Master;
import com.manage.service.MasterService;
/**
 * 公共操作控制
 * @author Administrator
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	@Autowired
	MasterService masterservice;
	/**
	 * 管理员个人资料设置
	 * @param id
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="setting")
	public String setting(@RequestParam("id") int id, HttpServletRequest req) {
		try {
			Master master = masterservice.getMasterByMid(id);
			req.setAttribute("muser", master);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "setting";
	}
	/**
	 * 管理员个人资料修改保存
	 * @return
	 */
	@RequestMapping(value="/revise", method=RequestMethod.POST)
	@ResponseBody
	public Map settingrevise(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String surepwd = req.getParameter("surepwd");
		String cname = req.getParameter("cname");
		String sex = req.getParameter("sex");
		String mobile = req.getParameter("mobile");
		String qq = req.getParameter("qq");
		String email = req.getParameter("email");
		if (StringUtils.isEmpty(id)) {
			retmap.put("status", CodeStatus.NEEDPARAM);
			retmap.put("msg", "参数缺失");
			return retmap;
		}
		if (StringUtils.isEmpty(pwd)) {
			retmap.put("status", CodeStatus.NEEDPARAM);
			retmap.put("msg", "用户名或密码不可为空");
			return retmap;
		}
		if (!pwd.equals(surepwd)) {
			retmap.put("status", CodeStatus.ERROR);
			retmap.put("msg", "两次输入密码不一致");
			return retmap;
		}
		Master master = masterservice.getMasterByMid(Integer.parseInt(id));
		if (master == null) {
			retmap.put("status", CodeStatus.ERROR);
			retmap.put("msg", "用户不存在");
			return retmap;
		}
		master.setM_pwd(MD5.getMD5(pwd.getBytes()));
		master.setM_cname(cname);
		master.setM_sex(Integer.valueOf(sex));
		master.setM_mobile(mobile);
		master.setM_qq(qq);
		master.setM_mail(email);
		if (masterservice.reviseMaster(master)) {
			retmap.put("status", CodeStatus.SUCCESS);
			retmap.put("msg", "成功");
		} else {
			retmap.put("status", CodeStatus.FAIL);
			retmap.put("msg", "失败");
		}
		return retmap;
	}
}
