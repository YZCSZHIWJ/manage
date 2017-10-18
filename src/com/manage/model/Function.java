package com.manage.model;

import java.io.Serializable;
import java.util.Date;

public class Function implements Serializable {
	private int f_id;//功能id
	private String f_name;//功能名称
	private String f_uri;//访问入口
	private Date f_ctime;//添加时间
	private String f_cuser;//添加管理员
	private String f_remark;//功能备注说明
	private int g_id;//功能组id
	private String g_name;//功能组名称
	private String g_tag;//功能组标示
	
	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_uri() {
		return f_uri;
	}

	public void setF_uri(String f_uri) {
		this.f_uri = f_uri;
	}

	public Date getF_ctime() {
		return f_ctime;
	}

	public void setF_ctime(Date f_ctime) {
		this.f_ctime = f_ctime;
	}

	public String getF_cuser() {
		return f_cuser;
	}

	public void setF_cuser(String f_cuser) {
		this.f_cuser = f_cuser;
	}

	public String getF_remark() {
		return f_remark;
	}

	public void setF_remark(String f_remark) {
		this.f_remark = f_remark;
	}

	public String getG_tag() {
		return g_tag;
	}

	public void setG_tag(String g_tag) {
		this.g_tag = g_tag;
	}

	@Override
	public String toString() {
		return "Function [f_id=" + f_id + ", g_id=" + g_id + ", f_name=" + f_name + ", f_uri=" + f_uri + ", f_ctime="
				+ f_ctime + ", f_cuser=" + f_cuser + ", f_remark=" + f_remark + "]";
	}
}
