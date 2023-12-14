package com.mirae.myapp;

import org.springframework.stereotype.Component;

@Component("bose")
public class Bose implements Speaker {

	public Bose() {
		System.out.println("Bose object constructed");
	}

	public void powerOn() {
		System.out.println("Bose power on");		
	}
	
	public void powerOff() {
		System.out.println("Bose power off");		
	}
	
	public void volumeUp() {
		System.out.println("Bose volume up");
	}
	
	public void volumeDown() {
		System.out.println("Bose volume down");		
	}
	
	public void initMethod() {
		System.out.println("Bose initMethod");
	}
	
	public void destroyMethod() {
		System.out.println("Bose destroyMethod");
	}
}
