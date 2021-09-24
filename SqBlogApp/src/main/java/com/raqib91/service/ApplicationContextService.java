package com.raqib91.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextService {

	public ApplicationContext getContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/raqib91/dao/ormConfig.xml");
		return context;
	}

}
