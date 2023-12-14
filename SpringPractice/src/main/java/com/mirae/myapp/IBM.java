package com.mirae.myapp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itv")
public class IBM implements TV {

	/* alternative annotations; @Resource has same effect as @Autowired + @Qualifier; @Inject is not supported by Spring
	@Autowired
	@Qualifier("bose")	*/
	@Resource(name="bose")
	private Speaker speaker;
	@Value("12345")
	private int price;
	
	public IBM() {
		System.out.println("IBM object constructed");
	}

	public void destroyMethod() {
		System.out.println("IBM destroyMethod");
	}
	
	@Override
	public void powerOn() {
		System.out.println("IBM power on");
		System.out.println("IBM price: " + price);
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
}
