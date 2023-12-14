package com.mirae.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// inversion of control; objects created by program at onset (pre-loading) or when needed (lazy-loading)
public class TVUser {

	public static void main(String[] args) throws InterruptedException {
//		BeanFactory beanFactory = new BeanFactory();
		// args[0] (Run Configurations > Arguments) to eventually be input from .xml file
//		TV tv = (TV) beanFactory.getBean(args[0]);
		
		// construct Spring container object; AbstractApplicationContext is grandparent of GenericXmlApplicationContext
		// Google bean is constructed here (pre-loading)
		System.out.println("***Spring container object constructor (Google: default, Samsung: lazy-init, LG: prototype)***");
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		
		System.out.println("***Google bean (tv) constructor + methods***");
		TV tv = (TV)beanFactory.getBean("gtv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		
		// Samsung bean is constructed here (lazy initialization)
		System.out.println("***Samsung bean (tv) constructor + methods***");
		tv = (TV)beanFactory.getBean("stv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		
		// gtv is set to the default singleton constructor; toString hash code will be the same 		
		System.out.println("***Google beans (tv1, tv2, tv3) constructors***");
		TV tv1 = (TV)beanFactory.getBean("gtv");
		TV tv2 = (TV)beanFactory.getBean("gtv");
		TV tv3 = (TV)beanFactory.getBean("gtv");
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		
		System.out.println("***Google beans (tv1, tv2, tv3) toString***");
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());

		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		
		// scope of ltv is set to prototype. this will create a new instance of the bean every time it is requested from the container; toString hash code will be different
		System.out.println("***LG beans (tv1, tv2, tv3) constuctors***");
		tv1 = (TV)beanFactory.getBean("ltv");
		tv2 = (TV)beanFactory.getBean("ltv");
		tv3 = (TV)beanFactory.getBean("ltv");		
	
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);

		System.out.println("***LG beans (tv1, tv2, tv3) toString***");
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);

		System.out.println("***LG beans (tv1, tv2, tv3) methods***");
		tv1.powerOn();
		tv2.powerOff();
		tv3.volumeUp();
		
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(2000);
		
		// because LG is set to prototype, destroyMethod is not called by container. Google (default) and Samsung (lazy-init) methods are
		System.out.println("***Spring container close***");
		beanFactory.close();
	}
}