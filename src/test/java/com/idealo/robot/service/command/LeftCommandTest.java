package com.idealo.robot.service.command;

import static org.junit.Assert.*;

import org.junit.Test;

import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;

public class LeftCommandTest {
	
	private InputCommand placeCommand;
	private Command leftCommand;
	private final ToyRobot robot = new ToyRobot() ;

	@Test
	public void testExecute() {
		//Need to place robot before left command otherwise left command will be ignored as robot is missing
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		leftCommand = new LeftCommand(robot);
		placeCommand.setAdditionalParams(0,0,Direction.NORTH);
		placeCommand.execute();
		leftCommand.execute();
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.WEST, robot.getPosition().getDirection());

	}
	@Test
	public void testExecuteWithoutRobot() {
		leftCommand = new LeftCommand(robot);
		leftCommand.execute();
		assertNull(robot.getPosition().getDirection());

	}

}
