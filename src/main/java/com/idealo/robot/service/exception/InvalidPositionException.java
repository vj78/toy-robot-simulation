package com.idealo.robot.service.exception;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = 4354301683960701423L;

	public InvalidPositionException(String msg) {
      super(msg);
	}
}