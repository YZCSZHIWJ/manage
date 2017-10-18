package com.common;
/**
 * 常用常参
 * @author wangjian
 * @time 2016年7月18日
 */
public interface CodeStatus {
	
	/**
	 * 成功
	 */
	int SUCCESS = 0;
	
	/**
	 * 缺失参数
	 */
	int NEEDPARAM = 101;
	
	/**
	 * 出错
	 */
	int ERROR = 100;

	/**
	 * 失败
	 */
	int FAIL = 103;
}
