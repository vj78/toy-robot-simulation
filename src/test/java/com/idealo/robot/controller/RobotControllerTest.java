package com.idealo.robot.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idealo.robot.dto.CommandDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RobotControllerTest {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void simulateRobotTestMove() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(new String[] { "PLACE 0,0,NORTH", "MOVE", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("0,1,NORTH", responseEntity.getBody());
	}

	@Test
	public void simulateRobotTestTurnLeft() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(new String[] { "PLACE 0,0,NORTH", "LEFT", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("0,0,WEST", responseEntity.getBody());
	}
	
	@Test
	public void simulateRobotTestTurnRight() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(new String[] { "PLACE 0,0,NORTH", "RIGHT", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("0,0,EAST", responseEntity.getBody());
	}
	
	@Test
	public void simulateRobotTestMultipleCommands1() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(new String[] { "PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("3,3,NORTH", responseEntity.getBody());
	}
	
	@Test
	public void simulateRobotTestMultipleCommands2() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(
				new String[] { "PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "RIGHT", "MOVE", "MOVE", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("5,3,EAST", responseEntity.getBody());
	}
	
	@Test
	public void simulateRobotTestRobotMissing() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(
				new String[] { "MOVE", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Robot Missing!", responseEntity.getBody());
	}
	
	@Test
	public void simulateRobotTestInvalidPlacement() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		CommandDTO commandDTO = new CommandDTO();
		commandDTO.setCommands(
				new String[] { "PLACE 7,7,NORTH","MOVE", "REPORT" });
		String jsonRequest = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(commandDTO);
		HttpEntity<String> requestEntity = buildHttpRequest(jsonRequest);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange("/v1/robot/simulate", HttpMethod.POST, requestEntity,
				String.class, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Invalid placement!", responseEntity.getBody());
	}
	
	private HttpEntity<String> buildHttpRequest(String requestBody) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
		HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
		return requestEntity;
	}
}
