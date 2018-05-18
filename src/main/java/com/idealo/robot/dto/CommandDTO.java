package com.idealo.robot.dto;

import javax.validation.constraints.NotNull;

public class CommandDTO {
	
	@NotNull(message = "Commands can not be null or empty!")
	private String[] commands;

	public String[] getCommands() {
		return commands;
	}

	public void setCommands(String[] commands) {
		this.commands = commands;
	}

	

}
