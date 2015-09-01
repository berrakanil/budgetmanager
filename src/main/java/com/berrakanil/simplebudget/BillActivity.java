package com.berrakanil.simplebudget;

public class BillActivity extends Activity {

	public BillActivity(float amount) {
		super(amount);
	}
	
	public String getName(){
		return ActivityType.BILL.getName();
	}
	
	public Direction getDirection() {
		return Direction.OUTCOME;
	}
}
