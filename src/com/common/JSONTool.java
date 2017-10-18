package com.common;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JSONTool {
	/**
	 * java对象序列化
	 * @author Administrator
	 * 2016年7月29日
	 * @param obj
	 * @return
	 */
	public static String toJsonStr(Object obj) {
		String jsonstr = "";
		jsonstr = JSON.toJSONString(obj);
		return jsonstr;
	}
	/**
	 * json字符串转义为普通对象
	 * @author Administrator
	 * 2016年7月29日
	 * @param jsonstr
	 * @return
	 */
	public static Object parseString(String jsonstr) {
		Object obj = JSON.parseObject(jsonstr);
		return obj;
	}
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", 0);
		map.put("msg", "success");
		String jsonstr = toJsonStr(map);
		System.out.println(jsonstr);
		Object obj = parseString(jsonstr);
		Map pmap = (Map) obj;
		System.out.println(pmap.get("status"));
		System.out.println(pmap.get("msg"));
	}
}
