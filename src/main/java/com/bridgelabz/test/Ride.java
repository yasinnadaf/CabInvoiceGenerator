package com.bridgelabz.test;

public class Ride {
    public double distance;
    public int time;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public enum category{
        NORMAL_RIDE(10, 1, 5);

        public double costPerKm;
        public int costPerMin;
        public double minFarePerRide;

        category(double costPerKm, int costPerMin, double minFarePerRide) {
            this.costPerKm = costPerKm;
            this.costPerMin = costPerMin;
            this.minFarePerRide = minFarePerRide;
        }

    }
}
