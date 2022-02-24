package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    //create members to store credit and debit amounts//
    private float[] credits;
    private float[] debits;

    //create constructor for SavingsCalculator//
    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }
    
    //create method that returns sum of credits//
    private float sumOfCredits() {
        float sum = 0.0f;
        for (float credit: credits) {
            sum += credit;
        }
        return sum;
    }

    //create method that returns sum of debits//
    private float sumOfDebits() {
       float sum = 0.0f;
       for ( float debit: debits) {
           sum += debit;
       }
       return sum;
    }
    
    //method that calculates days remaining in the month//
    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    //calculate net savings//
    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    //main() method that does tons of stuff//
    public static void main(String[] args) {
        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[creditsAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }
        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}
