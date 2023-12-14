package com.mirae.myapp;

public class Dell implements TV {

	private int price;
	private Speaker speaker;
	
	public Dell() {
		System.out.println("Dell object constructed");
	}

	public Dell(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("Dell initMethod");
		System.out.println("Dell price: " + price);
	}
	
	public void destroyMethod() {
		System.out.println("Dell destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Dell power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Dell power off");
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
