package com.mirae.myapp.ioc.injection;

import java.util.Map;

public class CollectionBeanMap {

	private Map<String, String> addressList;
	
	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	public Map<String, String> getAddressList() {
		return addressList;
	}
}
