package com.mirae.myapp;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("itv")
public class IBM implements TV {

	/* alternative annotations; @Resource has same effect as @Autowired + @Qualifier; @Inject is not supported by Spring
	@Autowired
	@Qualifier("bose")	*/
	@Resource(name="bose")
	private Speaker speaker;
	private int price;
	
	public IBM() {
		System.out.println("IBM object constructed");
	}

	public IBM(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("IBM initMethod");
		System.out.println("IBM price: " + price);
	}
	
	public void destroyMethod() {
		System.out.println("IBM destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("IBM power on");
	}

	@Override
	public void powerOff() {
		System.out.println("IBM power off");
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
