package com.idealo.robot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idealo.robot.service.exception.InvalidPositionException;
import com.idealo.robot.service.exception.RobotMissingException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(InvalidPositionException.class)
	public @ResponseBody String invalidPostionException(InvalidPositionException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(RobotMissingException.class)
	public @ResponseBody String robotMissingException(RobotMissingException e) {
		return e.getMessage();
	}

}
