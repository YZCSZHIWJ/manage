package com.ddz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddz.dao.FinanceDao;
import com.ddz.service.FinanceService;
@Service
public class FinanceServiceImpl implements FinanceService {
	@Autowired
	private FinanceDao fdao;

	@Override
	public int countReqGetMoneyNum(long userid, String last4, int status, int isout, String starttime, String endtime) {
		// TODO Auto-generated method stub
		try {
			int num = fdao.getMoneyReqNum(userid, last4, status, isout, starttime, endtime);
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getReqGetMoneyLst(long userid, String last4, int status, int isout, String starttime, String endtime,
			int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = fdao.getMoneyReqLst(userid, last4, status, isout, starttime, endtime, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
