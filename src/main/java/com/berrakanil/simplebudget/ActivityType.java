package com.berrakanil.simplebudget;

public enum ActivityType {
    FOOD("food"),
    BILL("bill"),
    SALARY("salary");

    String activityName;
    
    private ActivityType(String name) {
        this.activityName = name;
    }
    
    public String getName() {
        return activityName;
    }
}
