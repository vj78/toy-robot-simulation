package com.idealo.robot.service.command;

import static org.junit.Assert.*;

import org.junit.Test;

import com.idealo.robot.service.domain.Coordinates;
import com.idealo.robot.service.domain.Direction;
import com.idealo.robot.service.domain.ToyRobot;
import com.idealo.robot.service.exception.RobotMissingException;

public class ReportCommandTest {
	
	private InputCommand placeCommand;
	private Command leftCommand;
	private Command rightCommand;
	private Command moveCommand;
	private OutputCommand reportCommand;
	private final ToyRobot robot = new ToyRobot() ;

	@Test
	public void testExecuteTurnLeft() {
		//Need to place robot before left command otherwise left command will be ignored as robot is missing
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		leftCommand = new LeftCommand(robot);
		reportCommand = new ReportCommand(robot);
		placeCommand.setAdditionalParams(0,0,Direction.NORTH);
		placeCommand.execute();
		leftCommand.execute();
		reportCommand.execute();
		assertEquals("0,0,WEST", reportCommand.getOutput());

	}
	
	@Test
	public void testExecuteTurnLeftMove() {
		//Need to place robot before left command otherwise left command will be ignored as robot is missing
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		leftCommand = new LeftCommand(robot);
		moveCommand = new MoveCommand(robot, new Coordinates(5,5));
		reportCommand = new ReportCommand(robot);
		placeCommand.setAdditionalParams(3,4,Direction.NORTH);
		placeCommand.execute();
		leftCommand.execute();
		moveCommand.execute();
		reportCommand.execute();
		assertEquals("2,4,WEST", reportCommand.getOutput());

	}
	
	@Test
	public void testExecuteTurnRight() {
		//Need to place robot before right command otherwise right command will be ignored as robot is missing
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		rightCommand = new RightCommand(robot);
		reportCommand = new ReportCommand(robot);
		placeCommand.setAdditionalParams(0,0,Direction.NORTH);
		placeCommand.execute();
		rightCommand.execute();
		reportCommand.execute();
		assertEquals("0,0,EAST", reportCommand.getOutput());

	}
	
	@Test
	public void testExecuteTurnRightMove() {
		//Need to place robot before right command otherwise right command will be ignored as robot is missing
		placeCommand = new PlaceCommand(robot, 0,5,0,5);
		rightCommand = new RightCommand(robot);
		moveCommand = new MoveCommand(robot, new Coordinates(5,5));
		reportCommand = new ReportCommand(robot);
		placeCommand.setAdditionalParams(4,2,Direction.NORTH);
		placeCommand.execute();
		rightCommand.execute();
		moveCommand.execute();
		reportCommand.execute();
		assertEquals("5,2,EAST", reportCommand.getOutput());

	}
	
	
	@Test(expected = RobotMissingException.class)
	public void testExecuteWithoutRobot() {
		leftCommand = new LeftCommand(robot);
		reportCommand = new ReportCommand(robot);
		leftCommand.execute();
		reportCommand.execute();
		assertNull(robot.getPosition().getDirection());
		

	}

}
