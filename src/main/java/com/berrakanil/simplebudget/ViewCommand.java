package com.berrakanil.simplebudget;

import java.util.ArrayList;
import java.util.List;

public class ViewCommand extends Command {
	public enum HistoryDirection {
		INCOME("income"), OUTCOME("outcome"), ALL("all");
		private String historyDirection;

		public String getValue() {
			return historyDirection;
		}

		private HistoryDirection(String historyDirection) {
			this.historyDirection = historyDirection;
		}
	}

	private final int PARAMETER_COUNT = 1;

	public ViewCommand(String[] parameters, Account account) {
		super(parameters, account);
		if (parameters.length != PARAMETER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void execute() throws Exception {
		String[] parameters = this.getCommandParameters();
		List<Activity> list = new ArrayList<Activity>();
		if (parameters[0].toLowerCase().equals(HistoryDirection.ALL.getValue())) {
			list = getAccount().getAllAcitivtiyHistory();
		} else if (parameters[0].toLowerCase().equals(HistoryDirection.OUTCOME.getValue())) {
			list = getAccount().getOutcomeActivityHistory();
		} else if (parameters[0].toLowerCase().equals(HistoryDirection.INCOME.getValue())) {
			list = getAccount().getIncomeActivityHistory();
		} else {
			throw new IllegalArgumentException();
		}

		int listSize = list.size();
		if (listSize > 0) {
			String directionIcon;
			for (int i = 0; i < listSize; ++i) {
				Activity activity = list.get(i);
				if (activity.getDirection() == Direction.INCOME) {
					directionIcon = "->";
				} else {
					directionIcon = "<-";
				}
				System.out.println(
						directionIcon + activity.getName() + " " + activity.getAmount() + " " + activity.getDate());
			}
		} else {
			System.out.println("No activity found.");
		}
	}
}