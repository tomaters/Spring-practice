package com.mirae.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// inversion of control; objects created by program at onset (pre-loading) or when needed (lazy-loading)
public class TvUser {

	public static void main(String[] args) {
//		BeanFactory beanFactory = new BeanFactory();
		// args[0] (Run Configurations > Arguments) to eventually be input from .xml file
//		TV tv = (TV) beanFactory.getBean(args[0]);
		
	// only needed code; Spring container will do the rest
		// construct Spring container object; AbstractApplicationContext is grandparent of GenericXmlApplicationContext
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml");
		// in applicationContext.xml, change LG / Google / Samsung 
		TV tv = (TV)beanFactory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		beanFactory.close();
	}
}