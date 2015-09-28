package com.berrakanil.simplebudget;

import java.util.Arrays;
import java.util.Scanner;

public class BudgetManager {

    private Account m_account;
    private final String EXIT_COMMAND = "exit";

    public BudgetManager(Account account) {
        m_account = account;
    }

    private void displayMainMenu() {
        System.out.println("Type 'usage' for help");
        System.out.println("Please type an action:");
    }

    public void run() {
        String line;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                displayMainMenu();
                line = scanner.nextLine();
                String[] commands = line.split(" ");
                String commandName = extractCommandName(commands);
                String[] commandParameters = extractParameters(commands);

                if (commandName.toLowerCase().equals(EXIT_COMMAND)) {
                    System.exit(0);
                }

                Command command = CommandFactory.createCommand(commandName, commandParameters, m_account);
                command.execute();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String extractCommandName(String[] args) {
        if (args.length == 0) {
            return null;
        } else {
            return args[0];
        }
    }

    private static String[] extractParameters(String[] args) {
        if (args.length <= 1) {
            return new String[] {};
        } else {
            return Arrays.copyOfRange(args, 1, args.length);
        }
    }

}
