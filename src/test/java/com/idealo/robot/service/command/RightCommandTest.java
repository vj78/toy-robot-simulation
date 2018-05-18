package com.idealo.robot.service.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;

public class RightCommandTest {
	
	private InputCommand placeCommand;
	private Command rightCommand;
	private final ToyRobot robot = new ToyRobot() ;

	@Test
	public void testExecute() {
		//Need to place robot before right command otherwise right command will be ignored as robot is missing
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		rightCommand = new RightCommand(robot);
		placeCommand.setAdditionalParams(0,0,Direction.NORTH);
		placeCommand.execute();
		rightCommand.execute();
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.EAST, robot.getPosition().getDirection());

	}
	@Test
	public void testExecuteWithoutRobot() {
		rightCommand = new LeftCommand(robot);
		rightCommand.execute();
		assertNull(robot.getPosition().getDirection());

	}

}
