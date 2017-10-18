package com.ddz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddz.dao.OrderDao;
import com.ddz.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao odao;
	@Override
	public int countFlowOrderNum(long id, long tid, long userid, long sellerid, String account, int plat, int device,
			int status) {
		// TODO Auto-generated method stub
		try {
			int num = odao.countFlowOrderNum(id, tid, userid, sellerid, account, plat, device, status);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getFlowOrderLst(long id, long tid, long userid, long sellerid, String account, int plat, int device,
			int status, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = odao.getFlowOrderLst(id, tid, userid, sellerid, account, plat, device, status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getFlowOrderDetail(long id) {
		// TODO Auto-generated method stub
		try {
			Map map = odao.getFlowOrderDetail(id);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map cancelFlowOrder(long id, long userid, String remark, String admin) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("i_id", id);
			map.put("i_userid", userid);
			map.put("i_cancel_type", 20);
			map.put("i_remark", remark);
			map.put("i_admin", admin);
			map.put("o_result", 0);
			map.put("o_msg", "");
			odao.cancelFlowOrder(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countCanceledFlowOrderNum(long id, long tid, long userid, long sellerid, String account, int plat,
			int device, int status) {
		// TODO Auto-generated method stub
		try {
			int num = odao.countCanceledFlowOrderNum(tid, tid, userid, sellerid, account, plat, device, status);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getCanceledFlowOrderLst(long id, long tid, long userid, long sellerid, String account, int plat,
			int device, int status, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = odao.getCanceledFlowOrderLst(tid, tid, userid, sellerid, account, plat, device, status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getCanceledFlowOrderDetail(long id) {
		// TODO Auto-generated method stub
		try {
			Map map = odao.getCanceledFlowOrderDetail(id);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
