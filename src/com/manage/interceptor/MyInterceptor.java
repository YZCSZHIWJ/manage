package com.manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.common.IPTool;
import com.manage.model.Master;
import com.manage.service.SysService;


public class MyInterceptor implements HandlerInterceptor {
	@Autowired
	private SysService sysservice;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object handler, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		// TODO Auto-generated method stub
		try {
			Master master = (Master) req.getSession().getAttribute("master");
			if (master != null) {
				String ip = IPTool.getClientIP(req);
				String uri = req.getRequestURL().toString();
				String querystr = req.getQueryString();
				String url = querystr == null ? uri : uri + "?" + querystr;
				if (uri.indexOf("/css/") == -1 && uri.indexOf("/js/") == -1
						&& uri.indexOf("/images/") == -1 && uri.indexOf("/statics/") == -1
						&& uri.indexOf("/fonts/") == -1) {
					sysservice.addVisiteLog(master.getM_id(), master.getM_name(), url, ip);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

}
