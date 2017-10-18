package com.manage.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manage.model.Function;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml", "file:WebContent/WEB-INF/dispatcher-servlet.xml"})

public class FunctionServiceTest {
	private static final Logger log = LoggerFactory.getLogger(FunctionServiceTest.class);
	@Autowired
	FunctionService funcservice;
	@Ignore
	@Test
	public void testCountAllFuncNum() {
		int num = funcservice.countAllFuncNum();
		log.info("num = {}", num);
	}
}
