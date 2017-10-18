package com.ddz.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private long userid;//用户id
	private String uname;//登录用户名
	private String pwd;//登录密码
	private long mobile;//手机号码
	private String qq;
	private String email;
	private Date regtime;
	private String regip;
	private Date lasttime;
	private String lastip;
	private int sign;//登录标识，0.android，1.ios，2.web
	private String imei;//手机设备码
	private int level;//用户等级
	private int score;//积分
	private int status;//账号状态，0.正常，1.冻结
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", pwd=" + pwd + ", mobile=" + mobile + ", qq=" + qq
				+ ", email=" + email + ", regtime=" + regtime + ", regip=" + regip + ", lasttime=" + lasttime
				+ ", lastip=" + lastip + ", sign=" + sign + ", imei=" + imei + ", level=" + level + ", score=" + score
				+ ", status=" + status + "]";
	}
	
}
