package com.ddz.model;

import java.io.Serializable;

public class Account implements Serializable {
	private long userid;//用户id
	private double money;//本金账户
	private double gold;//佣金账户
	private double fmoney; //冻结账户
	private double today_income;  //今日总收入
	private double today_expense;  //今日总支出
	private double all_income;  //总收入
	private double all_expense; //总支出
	private double today_invite_income;  //今日邀请总收入
	private double discount; //商家折扣比例  0.9=9折
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getGold() {
		return gold;
	}
	public void setGold(double gold) {
		this.gold = gold;
	}
	public double getFmoney() {
		return fmoney;
	}
	public void setFmoney(double fmoney) {
		this.fmoney = fmoney;
	}
	public double getToday_income() {
		return today_income;
	}
	public void setToday_income(double today_income) {
		this.today_income = today_income;
	}
	public double getToday_expense() {
		return today_expense;
	}
	public void setToday_expense(double today_expense) {
		this.today_expense = today_expense;
	}
	public double getAll_income() {
		return all_income;
	}
	public void setAll_income(double all_income) {
		this.all_income = all_income;
	}
	public double getAll_expense() {
		return all_expense;
	}
	public void setAll_expense(double all_expense) {
		this.all_expense = all_expense;
	}
	public double getToday_invite_income() {
		return today_invite_income;
	}
	public void setToday_invite_income(double today_invite_income) {
		this.today_invite_income = today_invite_income;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Account [userid=" + userid + ", money=" + money + ", gold=" + gold + ", fmoney=" + fmoney
				+ ", today_income=" + today_income + ", today_expense=" + today_expense + ", all_income=" + all_income
				+ ", all_expense=" + all_expense + ", today_invite_income=" + today_invite_income + ", discount="
				+ discount + "]";
	}
}
