package com.ddz.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ddz.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})

public class UserDaoTest {
	private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);
	@Autowired
	UserDao udao;
	@Ignore
	@Test
	public void testGetUserByUserid() {
		try {
			long userid = 10000;
			User user = udao.getUserByUserid(userid);
			log.info(user+"");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testCountSmsSendNum() {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("mobile", 15256639892L);
			int count = udao.countSmsSendNum(param);
			log.info(count+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testgetSmsSendList() {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("firstPage", 0);
			param.put("pageSize", 20);
			List<Map<String, Object>> list = udao.getSmsSendList(param);
			for (Map<String, Object> item : list) {
				log.info(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
