package com.manage.model;

import java.io.Serializable;
import java.util.Date;

public class FunctionGroup implements Serializable {
	private int g_id;//功能组id
	private String g_name;//功能组名称
	private Date g_ctime;//功能组创建时间
	private String g_cuser;//功能组创建者
	private String g_remark;//组备注
	private String g_tag;//分组图标
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

	public Date getG_ctime() {
		return g_ctime;
	}

	public void setG_ctime(Date g_ctime) {
		this.g_ctime = g_ctime;
	}

	public String getG_cuser() {
		return g_cuser;
	}

	public void setG_cuser(String g_cuser) {
		this.g_cuser = g_cuser;
	}

	public String getG_remark() {
		return g_remark;
	}

	public void setG_remark(String g_remark) {
		this.g_remark = g_remark;
	}
	
	public String getG_tag() {
		return g_tag;
	}

	public void setG_tag(String g_tag) {
		this.g_tag = g_tag;
	}

	@Override
	public String toString() {
		return "FunctionGroup [g_id=" + g_id + ", g_name=" + g_name + ", g_ctime=" + g_ctime + ", g_cuser=" + g_cuser
				+ ", g_remark=" + g_remark + ", g_tag=" + g_tag + "]";
	}
	
}
