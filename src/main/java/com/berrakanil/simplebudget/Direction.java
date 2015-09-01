package com.berrakanil.simplebudget;

public enum Direction {
	INCOME(1),
	OUTCOME(2);
	
	private int direction;
	private Direction(int direction) {
		this.direction = direction;
	}
	
	public int getValue() {
		return direction;
	}
}
