package com.bridgelabz.test;

public class Ride {
    private int time;
    private double distance;
    private Category category;

    public Ride(Category category, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.category = category;
    }
    public enum Category{
        NORMAL_RIDE (10, 1, 5),PREMIUM_RIDE(15,2,20);

        public final double costPerKm;
        public final int costPerMin;
        public final double minFare;

        Category(double costPerKm, int costPerMin, double minFare) {
            this.costPerKm = costPerKm;
            this.costPerMin = costPerMin;
            this.minFare = minFare;
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}




