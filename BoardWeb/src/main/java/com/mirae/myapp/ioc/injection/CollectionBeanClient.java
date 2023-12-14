package com.mirae.myapp.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// construct Spring container
		AbstractApplicationContext beanFactory = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("***List type mapping***");
		CollectionBeanList collectionBean = (CollectionBeanList)beanFactory.getBean("collectionBean");
		List<String> list = collectionBean.getAddressList();
		for(String data : list) {
			System.out.println(data);
		}
		
		System.out.println("----------------------------------------------------------------");

		System.out.println("***Set type mapping***");
		CollectionBeanSet collectionBean2 = (CollectionBeanSet)beanFactory.getBean("collectionBeanSet");
		Set<String> set = collectionBean2.getAddressList();
		for(String data : set) {
			System.out.println(data);
		}
		
		System.out.println("----------------------------------------------------------------");

		System.out.println("***Map type mapping***");
		// keySet can only retrieve keys; entrySet can retrieve keys and their corresponding values
		CollectionBeanMap collectionBean3 = (CollectionBeanMap)beanFactory.getBean("collectionBeanMap");
		Map<String, String> map = collectionBean3.getAddressList();
		for(Map.Entry<String, String> data : map.entrySet()) {
			String key = data.getKey();
			String value = data.getValue();
			System.out.println(key + ": " + value);
		}
		
		System.out.println("----------------------------------------------------------------");
		
		System.out.println("***Properties type mapping***");
		CollectionBeanProperty collectionBean4 = (CollectionBeanProperty)beanFactory.getBean("collectionBeanProperty");
		Properties property = collectionBean4.getAddressList();
		for(Map.Entry<Object, Object> data : property.entrySet()) {
			String key = (String)data.getKey();
			String value = (String)data.getValue();
			System.out.println(key + ": " + value);
		}
		
		System.out.println("----------------------------------------------------------------");
		
		beanFactory.close();
	}
}
