package com.manage.controller;

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

import com.common.CodeStatus;
import com.common.Page;
import com.manage.model.Function;
import com.manage.model.FunctionGroup;
import com.manage.model.Master;
import com.manage.service.FunctionService;

@Controller
@RequestMapping(value="/function")
public class FunctionController {
	@Autowired
	private FunctionService funcservice;
	/**
	 * 功能及分组列表数据
	 * @param req
	 * @return
	 */
	@RequestMapping(value="")
	public String allFunction(HttpServletRequest req) {
		try {
			String pageIndex = req.getParameter("pageIndex");
			String pageSize = req.getParameter("pageSize");
			if (StringUtils.isEmpty(pageIndex)) {
				pageIndex = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "20";
			}
			int total = funcservice.countAllFuncNum();
			Page page = new Page(Integer.parseInt(pageIndex), total, Integer.parseInt(pageSize));
			if (total == 0) {
				page.setElements(new ArrayList<Function>());
			} else {
				List<Function> list = funcservice.getAllFunction(page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			List<FunctionGroup> funcgrouplist = funcservice.getAllFuncGroup();
			req.setAttribute("funcgrouplist", funcgrouplist);
			req.setAttribute("page", page);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "funcall";
	}
	
	/**
	 * 添加新功能页
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="add")
	public String funcAdd(Model model) {
		try {
			List<FunctionGroup> funcgrouplist = funcservice.getAllFuncGroup();
			model.addAttribute("grouplist", funcgrouplist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "funcadd";
	}
	/**
	 * 确定添加新的功能(ajax)
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Map addFunc(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			String g_id = req.getParameter("g_id");
			String f_name = req.getParameter("f_name");
			String f_uri = req.getParameter("f_uri");
			String f_remark = req.getParameter("f_remark");
			if (StringUtils.isEmpty(g_id) || StringUtils.isEmpty(f_name)
					|| StringUtils.isEmpty(f_uri) || StringUtils.isEmpty(f_remark)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "参数缺失");
				return retmap;
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "登录失效请重新登录");
				return retmap;
			}
			Function fn = new Function();
			fn.setG_id(Integer.valueOf(g_id));
			fn.setF_name(f_name);
			fn.setF_uri(f_uri);
			fn.setF_remark(f_remark);
			fn.setF_cuser(master.getM_name());
			if (funcservice.addFunction(fn)) {
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
	 * 修改功能页
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="revise")
	public String funcRevise(@RequestParam("f_id") int f_id, Model model) {
		try {
			Function fn = funcservice.getFunctionByFid(f_id);
			List<FunctionGroup> funcgrouplist = funcservice.getAllFuncGroup();
			model.addAttribute("fn", fn);
			model.addAttribute("grouplist", funcgrouplist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "funcrevise";
	}
	/**
	 * 修改功能(ajax)
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/revise", method=RequestMethod.POST)
	@ResponseBody
	public Map reviseFunc(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			String f_id = req.getParameter("f_id");
			String g_id = req.getParameter("g_id");
			String f_name = req.getParameter("f_name");
			String f_uri = req.getParameter("f_uri");
			String f_remark = req.getParameter("f_remark");
			if (StringUtils.isEmpty(g_id) || StringUtils.isEmpty(f_name)
					|| StringUtils.isEmpty(f_uri) || StringUtils.isEmpty(f_remark)
					|| StringUtils.isEmpty(f_id)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "参数缺失");
				return retmap;
			}
			Function fn = new Function();
			fn.setF_id(Integer.valueOf(f_id));
			fn.setG_id(Integer.valueOf(g_id));
			fn.setF_name(f_name);
			fn.setF_uri(f_uri);
			fn.setF_remark(f_remark);
			if (funcservice.reviseFunction(fn)) {
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
	 * 删除功能(ajax)
	 * @return
	 */
	@RequestMapping(value="/del", method=RequestMethod.POST)
	@ResponseBody
	public Map delFunc(@RequestParam("id") int id) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			if (funcservice.funcIsGranted(id)) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "功能已经分配给管理员，请回收后再删除");
				return retmap;
			}
			if (funcservice.delFunction(id)) {
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
	 * 添加功能分组页
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="addgroup")
	public String funcGroupAdd() {
		return "fgroupadd";
	}
	/**
	 * 添加分组(ajax)
	 * @author wangjian
	 * @time 2016年7月21日
	 * @return
	 */
	@RequestMapping(value="/addgroup", method=RequestMethod.POST)
	@ResponseBody
	public Map addGroup(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			String g_name = req.getParameter("g_name");
			String g_remark = req.getParameter("g_remark");
			String g_tag = req.getParameter("g_tag");
			if (StringUtils.isEmpty(g_name) || StringUtils.isEmpty(g_remark)
					|| StringUtils.isEmpty(g_tag)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "参数缺失");
				return retmap;
			}
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			FunctionGroup fg = new FunctionGroup();
			fg.setG_name(g_name);
			fg.setG_remark(g_remark);
			fg.setG_tag(g_tag);
			fg.setG_cuser(master.getM_name());
			if (funcservice.addFuncGroup(fg)) {
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
	 * 修改功能分组页
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="revisegroup")
	public String funcGroupRevise(@RequestParam("g_id") int g_id, Model model) {
		try {
			FunctionGroup fg = funcservice.getFuncGroupByGid(g_id);
			model.addAttribute("fg", fg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "fgrouprevise";
	}
	/**
	 * 修改功能分组(ajax)
	 * @author wangjian
	 * @time 2016年7月21日
	 * @return
	 */
	@RequestMapping(value="/revisegroup", method=RequestMethod.POST)
	@ResponseBody
	public Map reviseFuncGroup(HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			String g_id = req.getParameter("g_id");
			String g_name = req.getParameter("g_name");
			String g_remark = req.getParameter("g_remark");
			String g_tag = req.getParameter("g_tag");
			if (StringUtils.isEmpty(g_id) || StringUtils.isEmpty(g_name)
					|| StringUtils.isEmpty(g_remark) || StringUtils.isEmpty(g_tag)) {
				retmap.put("status", CodeStatus.NEEDPARAM);
				retmap.put("msg", "参数缺失");
				return retmap;
			}
			FunctionGroup fg = new FunctionGroup();
			fg.setG_id(Integer.parseInt(g_id));
			fg.setG_name(g_name);
			fg.setG_remark(g_remark);
			fg.setG_tag(g_tag);
			if (funcservice.reviseFuncGroup(fg)) {
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
	 * 删除分组(ajax)
	 * @author wangjian
	 * @time 2016年7月21日
	 * @return
	 */
	@RequestMapping(value="/delgroup", method=RequestMethod.POST)
	@ResponseBody
	public Map delFunctionGroup(@RequestParam("id") int g_id) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			if (funcservice.groupIsContainFunc(g_id)) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "群组包含功能，请先删除功能");
				return retmap;
			}
			if (funcservice.delFuncGroup(g_id)) {
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
	 * 功能已授权成员列表
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="grantedlist")
	public String grantMasterList(@RequestParam("f_id") int f_id, Model model) {
		try {
			Function fn = funcservice.getFunctionByFid(f_id);
			model.addAttribute("fn", fn);
			List list = funcservice.getFuncGrantMasterList(f_id);
			model.addAttribute("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "funcgramasters";
	}
	/**
	 * 功能未授权成员列表
	 * @author Administrator
	 * 2016年7月22日
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET, params="ungrantedlist")
	public String unGrantMasterList(@RequestParam("f_id") int f_id, Model model) {
		try {
			Function fn = funcservice.getFunctionByFid(f_id);
			model.addAttribute("fn", fn);
			List list = funcservice.getFuncUngrantMasterList(f_id);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "funcungramasters";
	}
	/**
	 * 授予管理员功能权限(ajax)
	 * @author wangjian
	 * @time 2016年7月23日
	 * @return
	 */
	@RequestMapping(value="/grant", method=RequestMethod.POST)
	@ResponseBody
	public Map grantFunc(@RequestParam("mid") int m_id, @RequestParam("fid") int f_id, HttpServletRequest req) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			Master master = (Master) req.getSession().getAttribute("master");
			if (master == null) {
				retmap.put("status", CodeStatus.ERROR);
				retmap.put("msg", "请退出重新登录");
				return retmap;
			}
			if (funcservice.grantMasterFunction(m_id, f_id, master.getM_name())) {
				retmap.put("status", CodeStatus.SUCCESS);
				retmap.put("msg", "成功");
			} else {
				retmap.put("status", CodeStatus.FAIL);
				retmap.put("msg", "失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retmap;
	}
	/**
	 * 权限回收(ajax)
	 * @author wangjian
	 * @time 2016年7月23日
	 * @return
	 */
	@RequestMapping(value="/recover", method=RequestMethod.POST)
	@ResponseBody
	public Map recoverFunc(@RequestParam("mid") int m_id, @RequestParam("fid") int f_id) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		retmap.put("status", CodeStatus.ERROR);
		retmap.put("msg", "出错");
		try {
			if (funcservice.recoverMasterFunction(m_id, f_id)) {
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
}
