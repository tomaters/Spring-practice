package com.mirae.myapp;

public class Panasonic implements Speaker {

	public Panasonic() {
		System.out.println("Panasonic object constructed");
	}

	public void powerOn() {
		System.out.println("Panasonic power on");		
	}
	
	public void powerOff() {
		System.out.println("Panasonic power off");		
	}
	
	public void volumeUp() {
		System.out.println("Panasonic volume up");
	}
	
	public void volumeDown() {
		System.out.println("Panasonic volume down");		
	}
	
	public void initMethod() {
		System.out.println("Panasonic initMethod");
	}
	
	public void destroyMethod() {
		System.out.println("Panasonic destroyMethod");
	}
}
