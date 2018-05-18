package com.idealo.robot.service.command;

import com.idealo.robot.service.domain.ToyRobot;
import com.idealo.robot.service.exception.RobotMissingException;

public class ReportCommand implements OutputCommand {

	private ToyRobot robot;
	private String report;
	
	
	public ReportCommand(ToyRobot robot) {
		this.robot = robot;
	}

	@Override
	public void execute() {
		if(robot.getPosition().getCoordinates()!=null && robot.getPosition().getDirection()!=null){
			this.report = robot.getPosition().toString();	
		} else {
			throw new RobotMissingException("Robot Missing!");
		}
		
	}

	@Override
	public Object getOutput() {
		return report;
	}

}
