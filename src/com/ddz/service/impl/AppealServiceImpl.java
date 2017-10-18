package com.ddz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddz.dao.AppealDao;
import com.ddz.service.AppealService;

@Service
public class AppealServiceImpl implements AppealService {
	@Autowired
	private AppealDao adao;

	@Override
	public int countAppealNum(long orderid, long userid, long beuserid, int appeal_type, int status,
			int plat_join_status, String starttime, String endtime) {
		// TODO Auto-generated method stub
		try {
			int num = adao.countAppealNum(orderid, userid, beuserid, appeal_type, status, plat_join_status, starttime, endtime);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getAppealLst(long orderid, long userid, long beuserid, int appeal_type, int status,
			int plat_join_status, String starttime, String endtime, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = adao.getAppealLst(orderid, userid, beuserid, appeal_type, status, plat_join_status, starttime, endtime, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map backAppeal(long orderid, int isflow, String admin, String content) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("i_orderid", orderid);
			map.put("i_isflow", isflow);
			map.put("i_userid", 0L);
			map.put("i_beuserid", 0L);
			map.put("i_appeal_type", 0);
			map.put("i_appeal_imges", "");
			map.put("i_appeal_reason", content);
			map.put("i_admin", admin);
			map.put("o_result", 0);
			map.put("o_msg", "");
			adao.backAppeal(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean overAppeal(long orderid, int isflow, String admin) {
		// TODO Auto-generated method stub
		try {
			int res = adao.overAppeal(orderid, isflow, admin);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List getAppealContent(long orderid, int isflow) {
		// TODO Auto-generated method stub
		try {
			List list = adao.getAppealContent(orderid, isflow);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getAppealMain(long orderid, int isflow) {
		// TODO Auto-generated method stub
		try {
			Map map = adao.getAppealMain(orderid, isflow);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
