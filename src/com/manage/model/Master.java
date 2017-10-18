package com.manage.model;

import java.io.Serializable;
import java.util.Date;

public class Master implements Serializable {
	private int m_id;//管理员id
	private String m_name;//管理员用户名，登录名
	private String m_pwd;//管理员密码
	private String m_cname;//管理员姓名
	private int m_sex;//性别，1.男，2.女
	private Date m_birthday;//出生日期
	private String m_mobile;//手机号码
	private String m_qq;//管理员qq
	private String m_mail;//邮箱
	private Date m_ctime;//创建时间
	private String m_cadmin;
	private int m_status;//管理员状态，0.正常，1.异常
	private String m_remark;//备注
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_cname() {
		return m_cname;
	}
	public void setM_cname(String m_cname) {
		this.m_cname = m_cname;
	}
	public int getM_sex() {
		return m_sex;
	}
	public void setM_sex(int m_sex) {
		this.m_sex = m_sex;
	}
	public Date getM_birthday() {
		return m_birthday;
	}
	public void setM_birthday(Date m_birthday) {
		this.m_birthday = m_birthday;
	}
	public String getM_mobile() {
		return m_mobile;
	}
	public void setM_mobile(String m_mobile) {
		this.m_mobile = m_mobile;
	}
	public String getM_qq() {
		return m_qq;
	}
	public void setM_qq(String m_qq) {
		this.m_qq = m_qq;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public Date getM_ctime() {
		return m_ctime;
	}
	public void setM_ctime(Date m_ctime) {
		this.m_ctime = m_ctime;
	}
	public String getM_cadmin() {
		return m_cadmin;
	}
	public void setM_cadmin(String m_cadmin) {
		this.m_cadmin = m_cadmin;
	}
	public int getM_status() {
		return m_status;
	}
	public void setM_status(int m_status) {
		this.m_status = m_status;
	}
	public String getM_remark() {
		return m_remark;
	}
	public void setM_remark(String m_remark) {
		this.m_remark = m_remark;
	}
	@Override
	public String toString() {
		return "Master [m_id=" + m_id + ", m_name=" + m_name + ", m_pwd=" + m_pwd + ", m_cname=" + m_cname + ", m_sex="
				+ m_sex + ", m_birthday=" + m_birthday + ", m_mobile=" + m_mobile + ", m_qq=" + m_qq + ", m_mail="
				+ m_mail + ", m_ctime=" + m_ctime + ", m_cadmin=" + m_cadmin + ", m_status=" + m_status + ", m_remark="
				+ m_remark + "]";
	}
}
