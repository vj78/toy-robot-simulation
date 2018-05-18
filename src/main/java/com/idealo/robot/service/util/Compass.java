package com.idealo.robot.service.util;

import com.idealo.robot.service.domain.Direction;

public class Compass {

	public static Direction findLeft(Direction direction) {
		return find(direction.getDirectionWeight()-1);
	}
	
	public static Direction findRight(Direction direction) {
		return find(direction.getDirectionWeight()+1);
	}
	
	private static Direction find(int directionWeight) {
		int value = (directionWeight < 1 || directionWeight==4) ? Direction.values().length: directionWeight % Direction.values().length ;
		return Direction.getDirection(value);
	}
}
