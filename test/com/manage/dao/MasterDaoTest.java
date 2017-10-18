package com.manage.dao;

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

import com.manage.model.Master;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})

public class MasterDaoTest {
	private final Logger log = LoggerFactory.getLogger(MasterDaoTest.class);
	@Autowired
	MasterDao mdao;
	@Ignore
	@Test
	public void testGetAllMaster() {
		try {
			List<Master> masterlist = mdao.getAllMaster();
			for (Master mas : masterlist) {
				log.info(mas.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void testGetMasterHasFunctions() {
		try {
			int id = 1000;
			List<Map<String, Object>> list = mdao.getMasterHasFunctions(id);
			for (Map item:list) {
				log.info(item.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testGetMastetNotHasFunctions() {
		try {
			int m_id = 1000;
			List<Map<String, Object>> list = mdao.getMastetNotHasFunctions(m_id);
			for (Map item:list) {
				log.info(item.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
