package com.mirae.controller.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// check settings on presentation-layer.xml
// whenever something is thrown, handle from here
// usually exceptions are handled on presentation-layer.xml
@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView illegalArgumentExceptionHandler(IllegalArgumentException e) {
		System.out.println("illegalArgumentExceptionHandler()");
		ModelAndView mav = new ModelAndView();
		
		// create view to display when an exception occurs
		mav.setViewName("common/illegalArgumentError");
		return mav;
	}
}