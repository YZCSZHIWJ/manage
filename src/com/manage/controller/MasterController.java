package com.manage.controller;

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

import com.common.CodeStatus;
import com.common.MD5;
import com.manage.model.Master;
import com.manage.service.MasterService;

@Controller
@RequestMapping(value="/master")
public class MasterController {
	
	@Autowired
	private MasterService masterservice;
	
	@RequestMapping(value="")
	public String masterlist(Model model) {
		try {
			List<Master> masterlist = masterservice.getAllMaster();
			model.addAttribute("masterlist", masterlist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "masterlist";
	}
	
	/**
	 * 管理员的冻结与解冻(ajax)
	 * @author wangjian
	 * @time 2016年7月20日
	 * @param m_id
	 * @param m_status
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST, params="statusopt")
	@ResponseBody
	public Map masterfreeze(@RequestParam("id") int m_id, @RequestParam("status") int m_status) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			if (masterservice.upMasterStatus(m_id, m_status)) {
				retmap.put("status", CodeStatus.SUCCESS);
				retmap.put("msg", "成功");
			} else {
				retmap.put("status", CodeStatus.FAIL);
				retmap.put("msg", "失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 管理员删除操作(ajax)
	 * @author wangjian
	 * @time 2016年7月20日
	 * @param m_id
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST, params="del")
	@ResponseBody
	public Map masterdelete(@RequestParam("id") int m_id) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			if (masterservice.delMaster(m_id)) {
				retmap.put("status", CodeStatus.SUCCESS);
				retmap.put("msg", "成功");
			} else {
				retmap.put("status", CodeStatus.FAIL);
				retmap.put("msg", "失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 添加管理员
	 * @author wangjian
	 * @time 2016年7月20日
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="add")
	public String addmaster() {
		return "masteradd";
	}
	/**
	 * 确认添加(ajax)
	 * @author wangjian
	 * @time 2016年7月20日
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Map doadd(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			String surepwd = req.getParameter("surepwd");
			String cname = req.getParameter("cname");
			String sex = req.getParameter("sex");
			String mobile = req.getParameter("mobile");
			String qq = req.getParameter("qq");
			String email = req.getParameter("email");
			String remark = req.getParameter("remark");
			if (StringUtils.isEmpty(uname) || StringUtils.isEmpty(pwd)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "用户名或密码不可为空");
				return retmap;
			}
			if (!pwd.equals(surepwd)) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "两次输入密码不一致");
				return retmap;
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			Master user = new Master();
			user.setM_name(uname);
			user.setM_pwd(MD5.getMD5(pwd.getBytes()));
			user.setM_cname(cname);
			user.setM_sex(Integer.parseInt(sex));
			user.setM_mobile(mobile);
			user.setM_qq(qq);
			user.setM_mail(email);
			user.setM_cadmin(master.getM_name());
			user.setM_remark(remark);
			if (masterservice.addMaster(user)) {
				retmap.put("status", CodeStatus.SUCCESS);
				retmap.put("msg", "成功");
			} else {
				retmap.put("status", CodeStatus.FAIL);
				retmap.put("msg", "失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 资料修改
	 * @author wangjian
	 * @time 2016年7月21日
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="revise")
	public String masterevise(@RequestParam("m_id") int m_id, Model model) {
		try {
			Master master = masterservice.getMasterByMid(m_id);
			model.addAttribute("muser", master);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "masterevise";
	}
	/**
	 * 确认修改资料
	 * @return
	 */
	@RequestMapping(value="/revise", method=RequestMethod.POST)
	@ResponseBody
	public Map dorevise(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			String id = req.getParameter("id");
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			String surepwd = req.getParameter("surepwd");
			String cname = req.getParameter("cname");
			String sex = req.getParameter("sex");
			String mobile = req.getParameter("mobile");
			String qq = req.getParameter("qq");
			String email = req.getParameter("email");
			String remark = req.getParameter("remark");
			if (StringUtils.isEmpty(id)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "参数缺失");
				return retmap;
			}
			if (StringUtils.isEmpty(uname) || StringUtils.isEmpty(pwd)) {
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
			master.setM_name(uname);
			master.setM_pwd(MD5.getMD5(pwd.getBytes()));
			master.setM_cname(cname);
			master.setM_sex(Integer.valueOf(sex));
			master.setM_mobile(mobile);
			master.setM_qq(qq);
			master.setM_mail(email);
			master.setM_remark(remark);
			if (masterservice.reviseMaster(master)) {
				retmap.put("status", CodeStatus.SUCCESS);
				retmap.put("msg", "成功");
			} else {
				retmap.put("status", CodeStatus.FAIL);
				retmap.put("msg", "失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retmap;
	}
	
	/**
	 * 已授权功能列表
	 * @author wangjian
	 * @time 2016年7月23日
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="grantfunclist")
	public String grantFuncList(@RequestParam("mid") int m_id, Model model) {
		try {
			Master user = masterservice.getMasterByMid(m_id);
			model.addAttribute("user", user);
			List list = masterservice.grantedFuncList(m_id);
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "m_grant_funlst";
	}
	/**
	 * 未授权功能列表
	 * @author wangjian
	 * @time 2016年7月23日
	 * @param m_id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="ungrantfunclist")
	public String unGrantFuncList(@RequestParam("mid")int m_id, Model model) {
		try {
			Master user = masterservice.getMasterByMid(m_id);
			model.addAttribute("user", user);
			List list = masterservice.ungrantFuncList(m_id);
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "m_ungrant_funlst";
	}
}
