package com.mirae.myapp;

public class Amazon implements TV {

	private int price;
	private Speaker speaker;
	
	public Amazon() {
		System.out.println("Amazon object constructed");
	}

	public Amazon(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("Amazon initMethod");
		System.out.println("Amazon price: " + price);
	}
	
	public void destroyMethod() {
		System.out.println("Amazon destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Amazon power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Amazon power off");
	}

	@Override
	public void volumeUp() {
		this.speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		this.speaker.volumeDown();
	}
}
