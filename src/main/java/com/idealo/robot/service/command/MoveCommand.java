package com.idealo.robot.service.command;

import com.idealo.robot.service.domain.Coordinates;
import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;

public class MoveCommand implements Command {

	private ToyRobot robot;
	private Coordinates boardCoordinates;
	
	
	public MoveCommand(ToyRobot robot, Coordinates boardCoordinates) {
		this.robot = robot;
		this.boardCoordinates = boardCoordinates;
	}

	@Override
	public void execute() {
		
		Direction direction = robot.getPosition().getDirection();
		Coordinates coordinates = robot.getPosition().getCoordinates();
		if (coordinates!=null && direction !=null) {
			switch (direction) {
			case NORTH:
				if (validateY(coordinates, 1)) {
					coordinates.change(0, 1);
				}
				break;
			case SOUTH:
				if (validateY(coordinates, -1)) {
					coordinates.change(0, -1);
				}
				break;
			case EAST:
				if (validateX(coordinates, 1)) {
					coordinates.change(1, 0);
				}
				break;
			case WEST:
				if (validateX(coordinates, -1)) {
					coordinates.change(-1, 0);
				}
				break;
			}
		}
		
	}
	
	private boolean validateX(Coordinates coordinates, int x) {
		if(x < 0){
			return coordinates.getRow() != 0;
		}
		if( x > 0 ) {
			return coordinates.getRow() != boardCoordinates.getRow();
		}		
		return true;
	}
	
	private boolean validateY(Coordinates coordinates, int y) {
		if(y < 0){
			return coordinates.getColumn() != 0;
		}
		if( y > 0 ) {
			return coordinates.getColumn() != boardCoordinates.getColumn();
		}
		return true;
	}

}
