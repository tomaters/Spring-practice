package com.mirae.myapp;

public class Google implements TV {
	
	public Google() {
		System.out.println("Google object constructed");
	}
	
	@Override
	public void powerOn() {
		System.out.println("GG power on");
	}

	@Override
	public void powerOff() {
		System.out.println("GG power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("GG volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("GG volume down");
	}
}
