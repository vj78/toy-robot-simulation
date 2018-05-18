package com.idealo.robot.service.exception;

public class RobotMissingException extends RuntimeException {

	private static final long serialVersionUID = 8216473537849746941L;

	public RobotMissingException(String msg) {
      super(msg);
	}
}