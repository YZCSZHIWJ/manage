package com.ddz.dao;

import java.util.List;

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
	
public class AppealDaoTest {
	private static final Logger log = LoggerFactory.getLogger(AppealDaoTest.class);
	@Autowired
	AppealDao adao;
	@Ignore
	@Test
	public void testCountAppealNum() {
		try {
			int num = adao.countAppealNum(-1, -1, -1, -1, 1, -1, null, null);
			log.info(num + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAppealLst() {
		try {
			List list = adao.getAppealLst(-1, -1, -1, -1, 1, -1, null, null, 0, 20);
			log.info(list+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
