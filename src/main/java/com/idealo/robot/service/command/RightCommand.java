package com.idealo.robot.service.command;

import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;
import com.idealo.robot.service.util.Compass;

public class RightCommand implements Command {

	private ToyRobot robot;
	
	public RightCommand(ToyRobot robot) {
		this.robot = robot;
	}

	@Override
	public void execute() {
		Direction direction = robot.getPosition().getDirection();
		if (direction != null) {
			this.robot.getPosition().changeDirection(Compass.findRight(direction));
		}
	}
}
