package com.mirae.myapp.ioc.injection;

import java.util.Properties;

public class CollectionBeanProperty {

	private Properties addressList; 
	
	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	
	public Properties getAddressList() {
		return addressList;
	}
}
