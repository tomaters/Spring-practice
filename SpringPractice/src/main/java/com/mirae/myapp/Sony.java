package com.mirae.myapp;

public class Sony implements Speaker {

	public Sony() {
		System.out.println("Sony object constructed");
	}

	public void powerOn() {
		System.out.println("Sony power on");		
	}
	
	public void powerOff() {
		System.out.println("Sony power off");		
	}
	
	public void volumeUp() {
		System.out.println("Sony volume up");
	}
	
	public void volumeDown() {
		System.out.println("Sony volume down");		
	}
	
	public void initMethod() {
		System.out.println("Sony initMethod");
	}
	
	public void destroyMethod() {
		System.out.println("Sony destroyMethod");
	}
}
