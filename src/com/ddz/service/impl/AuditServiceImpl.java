package com.ddz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddz.dao.AuditDao;
import com.ddz.dao.TaskDao;
import com.ddz.service.AuditService;
@Service
public class AuditServiceImpl implements AuditService {
	@Autowired
	private AuditDao adao;
	@Autowired
	private TaskDao tdao;
	@Override
	public int countAuditIdCardNum(long userid, String cname, String idcardnum, int status) {
		// TODO Auto-generated method stub
		try {
			int res = adao.countAuditIDCardNum(userid, cname, idcardnum, status);
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Map> getAuditIdCardLst(long userid, String cname, String idcardnum, int status, int firstPage,
			int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = adao.getAuditIDCardLst(userid, cname, idcardnum, status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean auditIdCard(long userid, int status, String reason, String admin) {
		// TODO Auto-generated method stub
		try {
			int res = adao.auditIdCard(userid, status, reason, admin);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int countBuyerAccNum(int plat, long userid, int status) {
		// TODO Auto-generated method stub
		try {
			int num = adao.countAuditBuyerAccNum(plat, userid, status);
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getBuyerAccLst(int plat, long userid, int status, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = adao.getAuditBuyerAccLst(plat, userid, status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean auditBuyerBindAcc(long id, long userid, int status, String reason, String admin) {
		// TODO Auto-generated method stub
		try {
			int res = adao.auditBuyerBindAcc(id, userid, status, reason, admin);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int countAuditHbNum(long userid, int status, int hb_status) {
		// TODO Auto-generated method stub
		try {
			int num = adao.countAuditHbNum(userid, status, hb_status);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getAuditHbLst(long userid, int status, int hb_status, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = adao.getAuditHbLst(userid, status, hb_status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean auditBuyerHb(long id, long userid, int hb_status, String reason, String admin) {
		// TODO Auto-generated method stub
		try {
			int res = adao.auditHb(id, userid, hb_status, reason, admin);
			return res > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int countBindShopNum(long userid, String shopname, int plat, int status) {
		// TODO Auto-generated method stub
		try {
			int num = adao.countBindShopNum(userid, shopname, plat, status);
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getBindShopLst(long userid, String shopname, int plat, int status, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = adao.getBindShopLst(userid, shopname, plat, status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean auditShop(long id, long userid, int status, String reason, String admin) {
		// TODO Auto-generated method stub
		try {
			int res = adao.auditBindShop(id, userid, status, reason, admin);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int countFlowTaskNum(long id, long userid, int status, int plat) {
		// TODO Auto-generated method stub
		try {
			int num = tdao.countFlowTaskNum(id, userid, plat, status);
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getFlowTaskLst(long id, long userid, int status, int plat, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = tdao.getFlowTaskLst(id, userid, plat, status, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map auditFlowTask(long id, long userid, int status, String reason, String admin) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("i_id", id);
			map.put("i_userid", userid);
			map.put("i_status", status);
			map.put("i_reason", reason);
			map.put("i_admin", admin);
			map.put("o_result", 0);
			map.put("o_msg", "");
			adao.auditFlowTask(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
