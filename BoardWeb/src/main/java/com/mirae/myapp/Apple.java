package com.mirae.myapp;

public class Apple implements TV {

	private int price;
	private Speaker speaker;
	
	public Apple() {
		System.out.println("Apple object constructed");
	}

	public Apple(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("Apple initMethod");
		System.out.println("Apple price: " + price);
	}
	
	public void destroyMethod() {
		System.out.println("Apple destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Apple power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Apple power off");
	}

	@Override
	public void volumeUp() {
		this.speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		this.speaker.volumeDown();
	}
	
	public int getPrice() {
		System.out.println("getPrice method called");
		return price;
	}
	
	public void setPrice(int price) {
		System.out.println("setPrice method called");
		this.price = price;
	}
	
	public Speaker getSpeaker() {
		System.out.println("getSpeaker method called");
		return speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker method called");
		this.speaker = speaker;
	}
}
