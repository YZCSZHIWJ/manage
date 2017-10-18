package com.common;

import java.util.HashMap;
import java.util.Map;

public enum StatusResult {
	SUCCESS(0, "成功"), 
	ERROR(100, "未知系统错误"), 
	NEEDPARAM(101, "参数缺失"), 
	FAILED(103, "操作失败"), 
	PARAMTYPERROR(105, "参数类型错误"), 
	TOKENFAIL(109, "token失效");
	
	private int status;
	private String msg;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	StatusResult(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public Map<String, Object> getRetMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("msg", msg);
		return map;
	}
}
