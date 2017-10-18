package com.manage.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manage.model.FunctionGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
public class FunctionDaoTest {
	private static final Logger log = LoggerFactory.getLogger(FunctionDaoTest.class);
	@Autowired
	FunctionDao fdao;
	@Test
	public void testGetAllFuncGroup() {
		try {
			List<FunctionGroup> list = fdao.getAllFuncGroup();
			for (FunctionGroup fg : list) {
				log.info(fg.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
