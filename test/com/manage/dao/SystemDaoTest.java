package com.manage.dao;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
public class SystemDaoTest {
	private static final Logger log = LoggerFactory.getLogger(SystemDaoTest.class);
	@Autowired
	SystemDao sdao;
	@Ignore
	@Test
	public void testAddLoginLog() {
		try {
			int m_id = 1000;
			String ip = "192.168.1.1";
			int res = sdao.addLoginLog(m_id, ip);
			log.info(res+"");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testGetMasterLoginLogList() {
		try {
			int m_id = 1000;
			int num = 0;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("i_m_id", m_id);
			map.put("o_n", num);
			List<Map> list = sdao.getMasterLoginLogList(map);
			for (Map item : list) {
				log.info(item+"");
			}
			log.info(map.get("o_n")+"");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
