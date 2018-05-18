package com.idealo.robot.service.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;
import com.idealo.robot.service.exception.InvalidPositionException;

public class PlaceCommandTest {

	private InputCommand placeCommand;
	private final ToyRobot robot = new ToyRobot() ;
	@Test
	public void testExecute() {
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		placeCommand.setAdditionalParams(0,0,Direction.NORTH);
		placeCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(0 == robot.getPosition().getCoordinates().getRow());
		assertTrue(0 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.NORTH, robot.getPosition().getDirection());
	}
	
	@Test(expected = InvalidPositionException.class)
	public void testExecuteInvalid() {
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		placeCommand.setAdditionalParams(-1,8,Direction.NORTH);
		placeCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(0 == robot.getPosition().getCoordinates().getRow());
		assertTrue(0 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.NORTH, robot.getPosition().getDirection());
	}

}
