package com.idealo.robot.service.domain;

public class TableTop {
	
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	public TableTop(int minX, int maxX, int minY, int maxY) {
		super();
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}
	public int getMinX() {
		return minX;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMinY() {
		return minY;
	}
	public int getMaxY() {
		return maxY;
	}
	
	
}
