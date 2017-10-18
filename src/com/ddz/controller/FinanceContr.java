package com.ddz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Page;
import com.ddz.service.FinanceService;
/**
 * 财务管理
 * @author wangjian
 * @time 2016年9月22日
 */
@Controller
@RequestMapping(value="/finance")
public class FinanceContr {
	@Autowired
	private FinanceService financeservice;
	
	/**
	 * 提现审核
	 * @author wangjian
	 * @time 2016年9月22日
	 * @param userid 用户id
	 * @param last4  银行账号后4位
	 * @param status 状态  0.待审核，1.通过，2.不通过
	 * @param isout -1.全部，0.未导出，1.已导出，2.完成
	 * @param starttime 请求时间区间
	 * @param endtime
	 * @param pageIndex
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/auditgetmoney")
	public String reqGetMoney(@RequestParam(value="userid", required=false, defaultValue="-1")long userid,
			@RequestParam(value="last4", required=false, defaultValue="")String last4,
			@RequestParam(value="status", required=false, defaultValue="0")int status, 
			@RequestParam(value="isout", required=false, defaultValue="-1")int isout,
			@RequestParam(value="starttime", required=false, defaultValue="")String starttime,
			@RequestParam(value="endtime", required=false, defaultValue="")String endtime,
			@RequestParam(value="pageIndex", required=false, defaultValue="1")int pageIndex,
			@RequestParam(value="pageSize", required=false, defaultValue="20")int pageSize, Model model) {
		try {
			int total = financeservice.countReqGetMoneyNum(userid, last4, status, isout, starttime, endtime);
			Page page = new Page(pageIndex, total, pageSize);
			if (total == 0) {
				page.setElements(new ArrayList());
			} else {
				List list = financeservice.getReqGetMoneyLst(userid, last4, status, isout, starttime, endtime, page.getFirst(), page.getPageSize());
				page.setElements(list);
			}
			model.addAttribute("page", page);
			model.addAttribute("status", status);
			model.addAttribute("isout", isout);
			model.addAttribute("starttime", starttime);
			model.addAttribute("endtime", endtime);
			if (userid > -1) model.addAttribute("userid", userid);
			if (!StringUtils.isEmpty(last4)) model.addAttribute("last4", last4);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "finance/req_money_list";
	}
}
