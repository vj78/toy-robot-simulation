package com.idealo.robot.service.command;

import com.idealo.robot.service.domain.Coordinates;
import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;
import com.idealo.robot.service.exception.InvalidPositionException;

public class PlaceCommand implements InputCommand {
	private ToyRobot robot;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private Integer row;
	private Integer column;
	private Direction direction;
	
	
	public PlaceCommand(ToyRobot robot, int minX, int maxX, int minY, int maxY) {
		super();
		this.robot = robot;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	@Override
	public void execute() {
		//validate boundaries
		if((this.row >= this.minX && this.row <=  this.maxX) &&
				(this.column >= this.minY && this.column <= this.maxY)) {
			robot.getPosition().init(new Coordinates(), this.direction);
			robot.getPosition().getCoordinates().change(this.row, this.column);
		} else {
			throw new InvalidPositionException("Invalid placement!");
		}
	}
	
	@Override
	public void setAdditionalParams(Object... params) {
		this.row = (Integer)params[0];
		this.column = (Integer)params[1];
		this.direction = (Direction)params[2];
	}

}
