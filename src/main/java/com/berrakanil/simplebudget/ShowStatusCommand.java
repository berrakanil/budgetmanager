package com.berrakanil.simplebudget;

public class ShowStatusCommand extends Command {

    private final int PARAMETER_COUNT = 0;

    public ShowStatusCommand(String[] parameters, Account account) {
        super(parameters, account);
        if (parameters.length != PARAMETER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void execute() throws Exception {
        float balanceAmount = getAccount().getBalance();
        float incomeAmount = getAccount().getTotalIncome();
        float outcomeAmount = getAccount().getTotalOutcome();

        System.out.println("Income  : " + incomeAmount);
        System.out.println("Outcome : " + outcomeAmount);
        System.out.println("Balance : " + balanceAmount);
    }
}
