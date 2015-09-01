package com.berrakanil.simplebudget;

public class App 
{
	public static void main( String[] args )
    {
        System.out.println( "Welcome to Budget Manager!" );
        Account newAccount = new Account();
        BudgetManager budgetManager = new BudgetManager(newAccount);
        budgetManager.run();
    }
}
