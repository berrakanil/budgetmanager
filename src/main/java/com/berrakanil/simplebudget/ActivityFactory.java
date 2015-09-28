package com.berrakanil.simplebudget;

public class ActivityFactory {
    
    public ActivityFactory() {}
    
    public static Activity createActivity(String type, float amount) throws Exception {
        if (type.toLowerCase().equals(ActivityType.FOOD.getName())) {
            return new FoodActivity(amount);
        } else if(type.toLowerCase().equals(ActivityType.BILL.getName())) {
            return new BillActivity(amount);
        } else if(type.toLowerCase().equals(ActivityType.SALARY.getName())) {
            return new SalaryActivity(amount);
        } 
        throw new IllegalArgumentException();
    }
}
