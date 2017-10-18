package com.manage.dto;

import java.util.ArrayList;
import java.util.List;

import com.manage.model.Function;
/**
 * 管理员开通功能分组
 * @author Administrator
 *
 */
public class MasterFunctionGroup {
	private int g_id;//组id
	private String g_name;//组名称
	private String g_tag;//组标签
	List<Function> f_list = new ArrayList<Function>();
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_tag() {
		return g_tag;
	}
	public void setG_tag(String g_tag) {
		this.g_tag = g_tag;
	}
	public List<Function> getF_list() {
		return f_list;
	}
	public void setF_list(List<Function> f_list) {
		this.f_list = f_list;
	}
	
}
