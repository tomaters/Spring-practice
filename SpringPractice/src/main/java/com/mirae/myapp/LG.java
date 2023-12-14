package com.mirae.myapp;

public class LG implements TV {
	
	public LG() {
		System.out.println("LG object constructed");
	}
	
	public void initMethod() {
		System.out.println("LG initMethod");
	}
	
	public void destroyMethod() {
		System.out.println("LG destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LG power on");
	}

	@Override
	public void powerOff() {
		System.out.println("LG power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("LG volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("LG volume down");
	}
}
