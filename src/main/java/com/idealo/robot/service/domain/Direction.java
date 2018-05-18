package com.idealo.robot.service.domain;

import java.util.stream.Stream;

public enum Direction {
	EAST(1),SOUTH(2),WEST(3),NORTH(4);
	
	private int directionWeight;
	
	private Direction(int directionWeight) {
		this.directionWeight = directionWeight;
		
	}
	
	public int getDirectionWeight() {
		return this.directionWeight;
	}

	public static Direction getDirection(int directionWeight) {
		return Stream.of(Direction.values()).filter(d -> d.directionWeight == directionWeight).findFirst().get();
	}
	
	public static Direction getDirection(String name) {
		return Stream.of(Direction.values()).filter(d -> d.toString().equals(name)).findFirst().get();
	}
	
	
}
