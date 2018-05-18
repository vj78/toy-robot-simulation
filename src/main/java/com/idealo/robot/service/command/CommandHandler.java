package com.idealo.robot.service.command;

import com.idealo.robot.service.domain.Coordinates;
import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.TableTop;
import com.idealo.robot.service.domain.ToyRobot;

public class CommandHandler {
	
	private InputCommand placeCommand;
	
	private Command leftCommand;
	
	private Command rightCommand;
	
	private Command moveCommand;
	
	private OutputCommand reportCommand;
	
	public CommandHandler(ToyRobot robot, TableTop tableTop) {
		placeCommand = new PlaceCommand(robot, tableTop.getMinX(), tableTop.getMaxX(), tableTop.getMinY(),
				tableTop.getMaxY());
		leftCommand = new LeftCommand(robot);
		rightCommand = new RightCommand(robot);
		moveCommand = new MoveCommand(robot, new Coordinates(tableTop.getMaxX(),tableTop.getMaxY()));
		reportCommand = new ReportCommand(robot);
	}

	public void place(Integer x, Integer y, Direction direction) {
		placeCommand.setAdditionalParams(x,y,direction);
		placeCommand.execute();
	}
	
	public void turnLeft() {
		leftCommand.execute();
	}
	
	public void turnRight() {
		rightCommand.execute();
	}
	
	public void move() {
		moveCommand.execute();
	}
	
	public String report() {
		reportCommand.execute();
		return (String)reportCommand.getOutput();
	}
}
