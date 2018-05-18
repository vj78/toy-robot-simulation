package com.idealo.robot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idealo.robot.dto.CommandDTO;
import com.idealo.robot.service.RobotSimulationService;

/**
 *  Simulation controller for robot that can process commands passed as input.
 */
@RestController
@RequestMapping("v1/robot/simulate")
public class RobotController {

	@Autowired
	private RobotSimulationService robotSimulationService;
	
	@PostMapping
    public String simulateRobot(@Valid @RequestBody CommandDTO commandDTO) {
		return robotSimulationService.simulateRobot(commandDTO.getCommands());
    }
}
