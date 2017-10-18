package com.ddz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddz.dao.UserDao;
import com.ddz.model.Account;
import com.ddz.model.User;
import com.ddz.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao udao;
	@Override
	public User getUserById(long userid) {
		// TODO Auto-generated method stub
		try {
			User user = udao.getUserByUserid(userid);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByMobile(long mobile) {
		// TODO Auto-generated method stub
		try {
			User user = udao.getUserByMobile(mobile);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getUserAccountById(long userid) {
		// TODO Auto-generated method stub
		try {
			Account account = udao.getUserAccount(userid);
			return account;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getUserBindList(long userid) {
		// TODO Auto-generated method stub
		try {
			List list = udao.getUserBindList(userid);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getUserBindBankList(long userid) {
		// TODO Auto-generated method stub
		try {
			List list = udao.getUserBindBankList(userid);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getUserBindShopList(long userid) {
		// TODO Auto-generated method stub
		try {
			List list = udao.getUserBindShopList(userid);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countSmsSendNum(long userid, long mobile) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			if (userid > -1) {
				param.put("userid", userid);
			}
			if (mobile > -1) {
				param.put("mobile", mobile);
			}
			int total = udao.countSmsSendNum(param);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getSmsSendList(long userid, long mobile, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			if (userid > -1) {
				param.put("userid", userid);
			}
			if (mobile > -1) {
				param.put("mobile", mobile);
			}
			param.put("firstPage", firstPage);
			param.put("pageSize", pageSize);
			List list = udao.getSmsSendList(param);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countMoneyDetailNum(long userid, int type, String search) {
		// TODO Auto-generated method stub
		try {
			int num = 0;
			switch (type) {
				case 1: num = udao.countMoneyDetailNum(userid, search);break;
				case 2: num = udao.countGoldDetailNum(userid, search);break;
				case 3: num = udao.countFmoneyDetailNum(userid, search);break;
			}
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getMoenyDetaulLst(long userid, int type, String search, int firstPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List list = null;
			switch (type) {
				case 1: list = udao.getMoenyDetailLst(userid, search, firstPage, pageSize);break;
				case 2: list = udao.getGoldDetailLst(userid, search, firstPage, pageSize);break;
				case 3: list = udao.getFmoneyDetailLst(userid, search, firstPage, pageSize);break;
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional("ddz")
	public void testTransaction() throws RuntimeException{
		// TODO Auto-generated method stub
		try {
			int res = udao.addTest1("wj", 10);
			udao.addTest2("aaaaa");
			throw new RuntimeException("my exception");
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
