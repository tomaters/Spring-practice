package com.mirae.myapp;

public class Samsung implements TV {
	
	public Samsung() {
		System.out.println("Samsung object constructed");
	}

	public void initMethod() {
		System.out.println("Samsung initMethod");
	}
	
	public void destroyMethod() {
		System.out.println("Samsung destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Samsung power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Samsung power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("Samsung volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("Samsung volume down");
	}
}
