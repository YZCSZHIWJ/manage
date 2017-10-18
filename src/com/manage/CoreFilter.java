package com.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.RequestUtil;
import com.manage.dto.MasterFunctionGroup;
import com.manage.model.Function;
import com.manage.model.Master;

public class CoreFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String uri = req.getRequestURI();
			Master master = (Master) req.getSession().getAttribute("master");
			if (uri.indexOf("/login") > -1 || uri.indexOf("/css/") > -1
					|| uri.indexOf("/js/") > -1 || uri.indexOf("/fonts/") > -1
					|| uri.indexOf("/images/") > -1 || uri.indexOf("/statics/") > -1) {//登录及静态资源不拦截
				chain.doFilter(request, response);
				return;
			} else {
				if (master == null) {
					res.sendRedirect("/login");
					return;
				}
			}
			if (RequestUtil.isAjaxRequest(req)) {
				uri = req.getHeader("referer");
			}
			List<Function> masterfunclist = (List<Function>) req.getSession().getAttribute("masterfunclist");
			if (masterfunclist == null) {
				res.sendRedirect("/login");
				return;
			}
			int g_id = -1, f_id = -1;
			if (uri.indexOf("/index") > -1 || uri.indexOf("/dashboard") > -1 || uri.indexOf("/common") > -1) {
				g_id = 0;
			} else {
				for (Function fn : masterfunclist) {
					String f_uri = fn.getF_uri();
					if (uri.indexOf(f_uri) > -1) {
						g_id = fn.getG_id();
						f_id = fn.getF_id();
					}
					if (uri.equals(f_uri)) {
						g_id = fn.getG_id();
						f_id = fn.getF_id();
						break;
					}
				}
			}
			if (g_id == -1) {//无权限
				res.sendRedirect("/statics/404.html");
				return;
			}
			req.setAttribute("g_id", g_id);
			req.setAttribute("f_id", f_id);
			chain.doFilter(request, response); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
		return;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
