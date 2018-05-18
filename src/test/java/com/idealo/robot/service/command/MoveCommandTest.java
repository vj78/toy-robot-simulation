package com.idealo.robot.service.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.idealo.robot.service.domain.Coordinates;
import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;

public class MoveCommandTest {

	private InputCommand placeCommand;
	private Command moveCommand;
	private final ToyRobot robot = new ToyRobot() ;
	@Test
	public void testExecuteMoveNorth() {
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(0,0,Direction.NORTH);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(1 == robot.getPosition().getCoordinates().getRow());
		assertTrue(0 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.NORTH, robot.getPosition().getDirection());
	}
	
	@Test
	public void testExecuteMoveNorthIgonoreCommand() {
		//Ignore command in order to fall robot from table top as boundary has been reached
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(5,5,Direction.NORTH);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(5 == robot.getPosition().getCoordinates().getRow());
		assertTrue(5 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.NORTH, robot.getPosition().getDirection());
	}
	
	@Test
	public void testExecuteMoveWest() {
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(2,2,Direction.WEST);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(2 == robot.getPosition().getCoordinates().getRow());
		assertTrue(1 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.WEST, robot.getPosition().getDirection());
	}
	@Test
	public void testExecuteMoveWestIgnoreCommand() {
		//Ignore command in order to fall robot from table top as boundary has been reached
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(0,0,Direction.WEST);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(0 == robot.getPosition().getCoordinates().getRow());
		assertTrue(0 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.WEST, robot.getPosition().getDirection());
	}
	@Test
	public void testExecuteMoveEast() {
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(0,0,Direction.EAST);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(0 == robot.getPosition().getCoordinates().getRow());
		assertTrue(1 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.EAST, robot.getPosition().getDirection());
	}
	
	@Test
	public void testExecuteMoveEastIgnoreCommand() {
		//Ignore command in order to fall robot from table top as boundary has been reached
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(5,5,Direction.EAST);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(5 == robot.getPosition().getCoordinates().getRow());
		assertTrue(5 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.EAST, robot.getPosition().getDirection());
	}
	
	@Test
	public void testExecuteMoveSouthIgnoreCommand() {
		//Ignore command in order to fall robot from table top as boundary has been reached
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(0,0,Direction.SOUTH);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(0 == robot.getPosition().getCoordinates().getRow());
		assertTrue(0 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
	}
	
	@Test
	public void testExecuteMoveSouth() {
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		moveCommand = new MoveCommand(robot, new Coordinates(5, 5));
		placeCommand.setAdditionalParams(2,2,Direction.SOUTH);
		placeCommand.execute();
		moveCommand.execute();
		assertNotNull(robot.getPosition().getCoordinates());
		assertTrue(1 == robot.getPosition().getCoordinates().getRow());
		assertTrue(2 == robot.getPosition().getCoordinates().getColumn());
		assertNotNull(robot.getPosition().getDirection());
		assertEquals(Direction.SOUTH, robot.getPosition().getDirection());
	}
}
