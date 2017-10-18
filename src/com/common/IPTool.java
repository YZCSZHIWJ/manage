package com.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * IP相关操作
 * @author wangjian
 * @time 2016年7月18日
 */
public class IPTool {
	//远端客户端代理可能添加的代理参数
	private static final String[] PROXY_REMOTE_IP_ADDRESS 
		= { "X-Forwarded-For","Proxy-Client-IP", "WL-Proxy-Client-IP", "X-Real-IP" };
	//局域网地址格式
	private static final Pattern INNER_IP_ADDR_RE
		= Pattern.compile("(10\\.)|(172\\.((1[6-9])|(2[0-9])|(3[0-1]))\\.)|(192\\.168\\.)");
	
	/**
	 * ip是否为局域网地址
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param ip
	 * @return true.是，false.否
	 */
	public static boolean isInnerIpAddr(String ip) {
        Matcher ipmatcher = INNER_IP_ADDR_RE.matcher(ip);
        return ipmatcher.find();
    }
	
	/**
	 * 从 HTTP Header 中截取客户端连接 IP 地址。如果经过多次反向代理， 
	 * 在请求头中获得的是以','分隔 IP 地址链，第一段为客户端 IP 地址
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param xforwardIp
	 * @return 
	 */
	private static String getRemoteIpFromForward( String xforwardIp ) {  
        int commaOffset = xforwardIp.indexOf(',');  
        if ( commaOffset < 0 ) {
            return xforwardIp;
        }
        return xforwardIp.substring( 0 , commaOffset );  
    } 
	
	/**
	 * 获取客户端真实ip地址
	 * @author wangjian
	 * @time 2016年7月18日
	 * @param req
	 * @return
	 */
	public static String getClientIP(HttpServletRequest req) {
        String ip = "";
        for (int i=0; i<PROXY_REMOTE_IP_ADDRESS.length; ++i) {
            ip = req.getHeader(PROXY_REMOTE_IP_ADDRESS[i]);
            if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) continue;
            ip = getRemoteIpFromForward(ip.trim()).trim();
            if (!isInnerIpAddr(ip)) {
                return ip;
            }
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }
        return ip;
    }
}
