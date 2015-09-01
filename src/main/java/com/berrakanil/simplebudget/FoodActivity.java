package com.berrakanil.simplebudget;

public class FoodActivity extends Activity {

	public FoodActivity(float amount) {
		super(amount);
	}
	
	public String getName(){
		return ActivityType.FOOD.getName();
	}
	
	public Direction getDirection() {
		return Direction.OUTCOME;
	}
}
