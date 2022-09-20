package com.bridgelabz.test;

public class CabInvoiceGenerator {
    public final int COST_PER_KM = 10;
    public final int COST_PER_MINUTE = 1;
    public int minFare = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = COST_PER_KM*distance + COST_PER_MINUTE*time;
        if(totalFare <= minFare ){
            totalFare = minFare;
        }
        return totalFare;
    }
}
