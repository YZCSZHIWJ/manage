package com.common;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	/**
	 * 判断是否为Ajax请求
	 * @param request   HttpServletRequest
	 * @return  是true, 否false
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
	    String requestType = request.getHeader("X-Requested-With");
	    if (requestType != null && requestType.equals("XMLHttpRequest")) {
	        return true;
	    } else {
	        return false;
	    }
	}
}
