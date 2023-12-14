package com.mirae.myapp;

public class Google implements TV {
	
	public Google() {
		System.out.println("Google object constructed");
	}
	
	public void initMethod() {
		System.out.println("Google initMethod");
	}
	
	public void destroyMethod() {
		System.out.println("Google destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Google power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Google power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("Google volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("Google volume down");
	}
}
