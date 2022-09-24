package com.bridgelabz.test;

public class CabInvoiceGenerator {
    public final int COST_PER_KM = 10;
    public final int COST_PER_MINUTE = 1;
    public int minFare = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = COST_PER_KM*distance + COST_PER_MINUTE*time;
        if(totalFare < minFare ){
            totalFare = minFare;
        }
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for(Ride ride : rides)
            totalFare += this.calculateFare(ride.distance, ride.time);

        return totalFare;
    }


}
