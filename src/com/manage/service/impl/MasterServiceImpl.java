package com.manage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.dao.FunctionDao;
import com.manage.dao.MasterDao;
import com.manage.dto.MasterFunctionGroup;
import com.manage.model.Function;
import com.manage.model.Master;
import com.manage.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	@Autowired
	private MasterDao mdao;
	@Autowired
	private FunctionDao fdao;
	
	@Override
	public Master doLoginMaster(String name, String pwd) {
		// TODO Auto-generated method stub
		try {
			Master master = mdao.getMasterByNameAndPwd(name, pwd);
			return master;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<MasterFunctionGroup> getMasterActFunc(int m_id) {
		// TODO Auto-generated method stub
		try {
			List<MasterFunctionGroup> mfglist = new ArrayList<MasterFunctionGroup>();//功能按群分后结果
			List<Function> mflist = fdao.getMasterOwnerFunction(m_id);//管理员所有开通的功能
			if (mflist!=null && mflist.size()>0) {
				MasterFunctionGroup mfgitem = new MasterFunctionGroup();
				mfglist.add(mfgitem);
				Function fitem = mflist.get(0);
				mfgitem.setG_id(fitem.getG_id());
				mfgitem.setG_name(fitem.getG_name());
				mfgitem.setG_tag(fitem.getG_tag());
				mfgitem.getF_list().add(fitem);
				for (int i=1; i<mflist.size(); i++) {
					if (fitem.getG_id() == mflist.get(i).getG_id()) {//功能所属同一个组
						mfgitem.getF_list().add(mflist.get(i));
					} else {//功能非同组
						mfgitem = new MasterFunctionGroup();
						mfglist.add(mfgitem);
						fitem = mflist.get(i);
						mfgitem.setG_id(fitem.getG_id());
						mfgitem.setG_name(fitem.getG_name());
						mfgitem.setG_tag(fitem.getG_tag());
						mfgitem.getF_list().add(fitem);
					}
				}
			}
			return mfglist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Master> getAllMaster() {
		// TODO Auto-generated method stub
		try {
			List<Master> allmaster = mdao.getAllMaster();
			return allmaster;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Function> getMasterFuncList(int m_id) {
		// TODO Auto-generated method stub
		try {
			List<Function> funclist = fdao.getMasterOwnerFunction(m_id);
			return funclist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	@Transactional
	public boolean delMaster(int m_id) {
		// TODO Auto-generated method stub
		try {
			int res = mdao.delMaster(m_id);
			mdao.removeMasterAllFunc(m_id);
			if (res <= 0) {
				throw new RuntimeException("master del failed");
			}
			return true;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean upMasterStatus(int m_id, int m_status) {
		// TODO Auto-generated method stub
		try {
			int res = mdao.freezeOrUnfreezeMaster(m_id, m_status);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean addMaster(Master master) {
		// TODO Auto-generated method stub
		try {
			int res = mdao.addMaster(master);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Master getMasterByMid(int m_id) {
		// TODO Auto-generated method stub
		try {
			Master master = mdao.getMasterById(m_id);
			return master;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean reviseMaster(Master master) {
		// TODO Auto-generated method stub
		try {
			int res = mdao.updateMaster(master);
			return res > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Map> grantedFuncList(int m_id) {
		// TODO Auto-generated method stub
		try {
			List list = mdao.getMasterHasFunctions(m_id);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Map> ungrantFuncList(int m_id) {
		// TODO Auto-generated method stub
		try {
			List list = mdao.getMastetNotHasFunctions(m_id);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
