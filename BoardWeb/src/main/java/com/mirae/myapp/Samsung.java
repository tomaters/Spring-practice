package com.mirae.myapp;

public class Samsung implements TV {
	
	private Sony speaker;
	
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
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
