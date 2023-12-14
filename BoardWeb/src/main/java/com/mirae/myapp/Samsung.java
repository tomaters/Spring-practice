package com.mirae.myapp;

public class Samsung implements TV {
	
	public Samsung() {
		System.out.println("Samsung object constructed");
	}

	@Override
	public void powerOn() {
		System.out.println("SS power on");
	}

	@Override
	public void powerOff() {
		System.out.println("SS power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("SS volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("SS volume down");
	}
}
