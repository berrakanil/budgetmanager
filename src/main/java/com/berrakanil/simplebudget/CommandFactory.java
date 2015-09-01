package com.berrakanil.simplebudget;

public class CommandFactory {

	public CommandFactory() {} 

	public static Command createCommand(String commandName, String[] commandParameters, Account account)
			throws Exception {

		//Show usage by default
		Command command = new UsageCommand(commandParameters, account);

		if (compareCommand(AddCommand.class, commandName)) {
			command = new AddCommand(commandParameters, account);
		} else if (compareCommand(ViewCommand.class, commandName)) {
			command = new ViewCommand(commandParameters, account);
		} else if (compareCommand(ShowStatusCommand.class, commandName)) {
			command = new ShowStatusCommand(commandParameters, account);
		}
		return command;
	}

	private static boolean compareCommand(Class<? extends Command> cmd, String name) {
		return Command.getClassName(cmd).equals(name.toLowerCase());
	}
}
