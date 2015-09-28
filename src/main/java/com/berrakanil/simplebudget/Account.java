package com.berrakanil.simplebudget;

import java.util.ArrayList;
import java.util.List;

public class Account {
    
    List<Activity> activityList;
    public Account() {
        activityList = new ArrayList<Activity>();
    }
    
    public void addActivity(Activity newActivity){
        activityList.add(newActivity);
    }

    public int getActivityCount() {
        return activityList.size();
    }
    
    public float getBalance() {
        float totalAmount = 0;
        for (int i = 0; i < activityList.size(); ++i) {
            if (activityList.get(i).getDirection() == Direction.INCOME) {
                    totalAmount += activityList.get(i).getAmount();
            }
            else {
                    totalAmount -= activityList.get(i).getAmount();
            }
        }
        return totalAmount;
    }
    
    public float getTotalOutcome() {
        float totalOutcome = 0;
        for(int i = 0; i < activityList.size(); ++i) {
            if (activityList.get(i).getDirection() == Direction.OUTCOME) {
                totalOutcome += activityList.get(i).getAmount();
            }
        }
        return totalOutcome;
    }
    
    public float getTotalIncome() {
        float totalIncome = 0;
        for(int i = 0; i < activityList.size(); ++i) {
            if (activityList.get(i).getDirection() == Direction.INCOME) {
                totalIncome += activityList.get(i).getAmount();
            }
        }
        return totalIncome;
    }
    
    public List<Activity> getAllAcitivtiyHistory() {
        return activityList;
    }

    public List<Activity> getOutcomeActivityHistory() {
        return getActivityHistoryByDirection(Direction.OUTCOME);
    }

    public List<Activity> getIncomeActivityHistory() {
        return getActivityHistoryByDirection(Direction.INCOME);
    }
    
    private List<Activity> getActivityHistoryByDirection(Direction direction) {
        List<Activity> newActivityList = new ArrayList<Activity>();
        for(int i = 0; i < activityList.size(); ++i) {
            if (activityList.get(i).getDirection() == direction) {
                newActivityList.add(activityList.get(i));
            }
        }
        return newActivityList;
    }
        
}
