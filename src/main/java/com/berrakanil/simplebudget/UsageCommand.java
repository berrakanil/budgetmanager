package com.berrakanil.simplebudget;

public class UsageCommand extends Command {

    public UsageCommand(String[] parameters, Account account) {
        super(parameters, account);
    }

    @Override
    public void execute() {
        System.out.println("supported commands are:");
        System.out.println("> " + Command.getClassName(AddCommand.class) + " [name] [amount]");
        System.out.println("> " + Command.getClassName(ShowStatusCommand.class));
        System.out.println("> " + Command.getClassName(ViewCommand.class) + " [income|outcome|all]");
        System.out.println("> " + Command.getClassName(UsageCommand.class));
        System.out.println("> " + "exit");
    }
}
