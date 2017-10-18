package com.manage.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml", "file:WebContent/WEB-INF/dispatcher-servlet.xml"})

public class SysServiceTest {
	private static final Logger log = LoggerFactory.getLogger(SysServiceTest.class);
	@Autowired
	SysService sysservice;
	@Test
	public void testTransaction() {
		sysservice.testTransaction();
	}
}
