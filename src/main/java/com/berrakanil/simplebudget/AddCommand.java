package com.berrakanil.simplebudget;

public class AddCommand extends Command {
	
	private final int PARAMETER_COUNT = 2;
	
	public AddCommand(String[] parameters, Account account) {
		super(parameters, account);
		if (parameters.length !=  PARAMETER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void execute() throws Exception {
		String[] parameters = this.getCommandParameters();
		Activity newActivity = ActivityFactory.createActivity(parameters[0],Float.parseFloat(parameters[1]));
		getAccount().addActivity(newActivity);
	}
}
