package com.berrakanil.simplebudget;

public abstract class Command {
    private String[] m_commandParameters = new String[] {};
    private Account m_account;

    public Command(String[] parameters, Account account) {
        this.m_account = account;
        this.m_commandParameters = parameters;
    }

    public String[] getCommandParameters() {
        return this.m_commandParameters;
    }

    public abstract void execute() throws Exception;

    public static String getClassName(Class<? extends Command> cmd) {
        return (cmd.getSimpleName().replaceAll("Command$", "").toLowerCase());
    }

    public Account getAccount() {
        return m_account;
    }
}
