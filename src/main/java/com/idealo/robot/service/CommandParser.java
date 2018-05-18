package com.idealo.robot.service;

import com.idealo.robot.service.domain.Action;
import com.idealo.robot.service.domain.Direction;

public class CommandParser {
	
	public static boolean validatePlaceCommand(String[] params) {

		try {
			Action action = Action.valueOf(params[0]);
			String[] commandParams = params[1].split(",");
			int x = Integer.valueOf(commandParams[0]);
			int y = Integer.valueOf(commandParams[1]);
			Direction direction = Direction.getDirection(commandParams[2]);
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument to Place Command", e);
		}
		return true;
	}

	public static boolean validateCommand(String param) {

		try {
			Action action = Action.valueOf(param);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid Command", e);
		}
		return true;
	}
}