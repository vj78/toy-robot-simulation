package com.idealo.robot.service.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.idealo.robot.service.domain.Direction;

public class CompassTest {

	@Test
	public void testFindLeft() {
		assertEquals(Direction.WEST, Compass.findLeft(Direction.NORTH));
		assertEquals(Direction.SOUTH, Compass.findLeft(Direction.WEST));
		assertEquals(Direction.EAST, Compass.findLeft(Direction.SOUTH));
		assertEquals(Direction.NORTH, Compass.findLeft(Direction.EAST));
	}
	
	@Test
	public void testFindRight() {
		assertEquals(Direction.EAST, Compass.findRight(Direction.NORTH));
		assertEquals(Direction.SOUTH, Compass.findRight(Direction.EAST));
		assertEquals(Direction.WEST, Compass.findRight(Direction.SOUTH));
		assertEquals(Direction.NORTH, Compass.findRight(Direction.WEST));
	}

}
