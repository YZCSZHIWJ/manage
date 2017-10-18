package com.ddz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddz.dao.TaskDao;
import com.ddz.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao tdao;

	@Override
	public int countAuditedFlowTaskNum(long id, long userid, int plat, int progress) {
		// TODO Auto-generated method stub
		try {
			int num = tdao.countAuditedFlowTaskNum(id, userid, plat, progress);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getAuditedFlowTaskLst(long id, long userid, int plat, int progress, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = tdao.getAuditedFlowTaskLst(id, userid, plat, progress, firstPage, pageSize);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getFlowTaskDetail(long id) {
		// TODO Auto-generated method stub
		try {
			Map map = tdao.getFlowTaskDetail(id);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getFlowTaskLimit(long id) {
		// TODO Auto-generated method stub
		try {
			Map map = tdao.getFlowTaskLimit(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getFlowTaskTimeset(long id) {
		// TODO Auto-generated method stub
		try {
			Map map = tdao.getFlowTaskTimeSet(id);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getFlowTaskKeywordes(long id) {
		// TODO Auto-generated method stub
		try {
			List list = tdao.getFlowTaskKeywordes(id);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map getFlowTaskPay(long id) {
		// TODO Auto-generated method stub
		try {
			Map map = tdao.getFlowTaskPay(id);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
