package com.mirae.myapp;

public class BeanFactory {
	public Object getBean(String beanName) {
		Object obj = null;
		switch(beanName) {
		case "samsung": 
			obj = new Samsung(); break;
		case "lg": 
			obj = new LG();	break;
		case "google": 
			obj = new Google(); break;
		default: obj = null;
		}
		return obj;
	}
}
