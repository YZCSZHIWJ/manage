package com.manage.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.dao.SystemDao;
import com.manage.service.SysService;

@Service
public class SysServiceImpl implements SysService {
	@Autowired
	private SystemDao sdao;
	@Override
	public boolean addLoginLog(int m_id, String ip) {
		// TODO Auto-generated method stub
		try {
			int res = sdao.addLoginLog(m_id, ip);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean addVisiteLog(int m_id, String m_name, String url, String ip) {
		// TODO Auto-generated method stub
		try {
			int res = sdao.addVisiteLog(m_id, m_name, url, ip);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	@Transactional("manage")
	public void testTransaction() {
		// TODO Auto-generated method stub
		try {
			sdao.addToTestTb("peter");
			throw new RuntimeException("manage runtime exception");
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
