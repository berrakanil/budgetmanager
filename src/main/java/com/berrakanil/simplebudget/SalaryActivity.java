package com.berrakanil.simplebudget;

public class SalaryActivity extends Activity {

	public SalaryActivity(float amount) {
		super(amount);
	}	
	
	public String getName(){
		return ActivityType.SALARY.getName();
	}
	
	public Direction getDirection() {
		return Direction.INCOME;
	}
}
