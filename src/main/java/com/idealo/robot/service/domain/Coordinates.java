package com.idealo.robot.service.domain;

public class Coordinates {
	private int row;
	private int column;
	
	public Coordinates(){
		this.row = 0;
		this.column = 0;
	}
	
	
	public Coordinates(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}


	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}
	
	public void change(int xUnit, int yUnit) {
		this.column = this.column + xUnit;
		this.row = this.row + yUnit;
	}

	@Override
	public String toString() {
		return this.column + "," + this.row;
	}
	
	
}
