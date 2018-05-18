package com.idealo.robot.service.domain;

public class Position {

	private Coordinates coordinates;
	private Direction direction;
	
	public Position() {
		
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public Direction getDirection() {
		return direction;
	}
	public void init(Coordinates coordinates, Direction direction) {
		this.coordinates = coordinates;
		this.direction = direction;
	}

	public Direction changeDirection(Direction direction) {
		return this.direction = direction;
	}

	@Override
	public String toString() {
		return coordinates + "," + direction.name();
	}
	
	
	
}

