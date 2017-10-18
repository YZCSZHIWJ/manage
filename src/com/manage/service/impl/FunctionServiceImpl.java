package com.manage.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.dao.FunctionDao;
import com.manage.model.Function;
import com.manage.model.FunctionGroup;
import com.manage.service.FunctionService;
@Service
public class FunctionServiceImpl implements FunctionService {
	private static final Logger log = LoggerFactory.getLogger(FunctionServiceImpl.class);
	@Autowired
	private FunctionDao fdao;
	@Override
	public List<Function> getAllFunction(int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List<Function> allfunc = fdao.getAllFunction(firstPage, pageSize);
			return allfunc;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int countAllFuncNum() {
		// TODO Auto-generated method stub
		try {
			int num = fdao.countAllFuncNum();
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<FunctionGroup> getAllFuncGroup() {
		// TODO Auto-generated method stub
		try {
			List<FunctionGroup> list = fdao.getAllFuncGroup();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addFunction(Function fn) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.addFunc(fn);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean reviseFunction(Function fn) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.updateFunc(fn);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delFunction(int f_id) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.delFunc(f_id);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Function getFunctionByFid(int f_id) {
		// TODO Auto-generated method stub
		try {
			Function fn = fdao.getFuncByFid(f_id);
			return fn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean funcIsGranted(int f_id) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.funGrantMasterNum(f_id);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public FunctionGroup getFuncGroupByGid(int g_id) {
		// TODO Auto-generated method stub
		try {
			FunctionGroup fg = fdao.getFuncGroupByGid(g_id);
			return fg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addFuncGroup(FunctionGroup fg) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.addFuncGroup(fg);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean reviseFuncGroup(FunctionGroup fg) {
		// TODO Auto-generated method stub
		try {
			int res= fdao.updateFuncGroup(fg);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delFuncGroup(int g_id) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.delFuncGroup(g_id);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean groupIsContainFunc(int g_id) {
		// TODO Auto-generated method stub
		try {
			int funcnum = fdao.groupHasFuncNum(g_id);
			return funcnum > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Map<String, Object>> getFuncGrantMasterList(int f_id) {
		// TODO Auto-generated method stub
		try {
			List<Map<String, Object>> list = fdao.getFuncGrantMasteres(f_id);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Map<String, Object>> getFuncUngrantMasterList(int f_id) {
		// TODO Auto-generated method stub
		try {
			List<Map<String, Object>> list = fdao.getFuncUnGrantMasteres(f_id);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean grantMasterFunction(int m_id, int f_id, String admin) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.grantMasterFunc(m_id, f_id, admin);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean recoverMasterFunction(int m_id, int f_id) {
		// TODO Auto-generated method stub
		try {
			int res = fdao.recoverMasterFunc(m_id, f_id);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
