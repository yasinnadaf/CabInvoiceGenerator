package com.bridgelabz.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CabInvoiceGenerator {
    static List<Customer> customerList = new ArrayList<>();

    public static double calculateFare(double distance, int time) {
        double totalFare = distance*Ride.Category.NORMAL_RIDE.costPerKm + time*Ride.Category.NORMAL_RIDE.costPerMin;
        return totalFare < Ride.Category.NORMAL_RIDE.minFare ? Ride.Category.NORMAL_RIDE.minFare : totalFare;

    }

    public static double calculateFare(Ride.Category category, double distance, int time){
        if (category.equals(Ride.Category.PREMIUM_RIDE)) {
            double totalFare = distance * category.costPerKm+ time * category.costPerMin;
            if (totalFare <= category.minFare)
                return category.minFare;
            return totalFare;
        } else if(category.equals(Ride.Category.NORMAL_RIDE)) {
            double totalFare = distance * category.costPerKm + time * category.costPerMin;
            if (totalFare <= category.minFare)
                return category.minFare;
            return totalFare;
        } else
            return 0;
    }

    public static double calculateFare(Ride[] totalRide) {
        double totalFare = 0;
        for (Ride ride : totalRide) {
            totalFare += calculateFare(ride.getCategory(),ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    public static Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateFare(rides);
        int totalNumberOfRides = rides.length;
        double averageFare = totalFare / totalNumberOfRides;
        return new Invoice(totalNumberOfRides,totalFare,averageFare);
    }

    public static Invoice generateInvoice(int id) {
        List<Customer> customerList1 = customerList.stream().filter(customer -> customer.id == id).collect(Collectors.toList());
        Customer customer = customerList1.get(0);
        return generateInvoice(customer.rideList);
    }


}
