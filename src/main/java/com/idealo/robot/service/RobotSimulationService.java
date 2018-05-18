package com.idealo.robot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idealo.robot.config.TableTopConfig;
import com.idealo.robot.service.command.CommandHandler;
import com.idealo.robot.service.domain.Action;
import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.TableTop;
import com.idealo.robot.service.domain.ToyRobot;

@Service
public class RobotSimulationService {

	 @Autowired
	 private TableTopConfig tableTopConfig;
	 private TableTop tableTop;
	 private ToyRobot robot;
	 private CommandHandler commandHandler;
	 private String report;
	 
	public String simulateRobot(String[] commands) {
		this.tableTop = new TableTop(Integer.parseInt(tableTopConfig.getMinX()),
				Integer.parseInt(tableTopConfig.getMaxX()), Integer.parseInt(tableTopConfig.getMinY()),
				Integer.parseInt(tableTopConfig.getMaxY()));
		this.robot = new ToyRobot();
		this.commandHandler = new CommandHandler(robot, tableTop);
		// Process commands
		for (String command : commands) {
			processCommand(command);
		}
		return this.report;
	}
	 
	private void processCommand(String command) {
		String[] commandsParams = null;
		String commandStr = command.trim();
		if (command.contains(Action.PLACE.name())) {
			commandsParams = command.split(" ");
			// Validate PLACE command and its parameters
			CommandParser.validatePlaceCommand(commandsParams);
			commandStr = commandsParams[0];
		} else {
			// Validate other commands
			CommandParser.validateCommand(command);
		}
		Action action = Action.valueOf(commandStr.trim());
		switch (action) {
			case PLACE:
				String[] params = commandsParams[1].split(",");
				int x = Integer.parseInt(params[0]);
				int y = Integer.parseInt(params[1]);
				Direction direction = Direction.getDirection(params[2]);
				commandHandler.place(x, y, direction);
				break;
			case LEFT:
				commandHandler.turnLeft();
				break;
			case RIGHT:
				commandHandler.turnRight();
				break;
			case MOVE:
				commandHandler.move();
				break;
			case REPORT:
				this.report = commandHandler.report();
				break;
			}
	}
}
