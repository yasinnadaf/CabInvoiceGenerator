package com.bridgelabz.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator generator;
    @BeforeEach
    void initialize(){
        generator = new CabInvoiceGenerator();
    }

    @Test
    void givenDistanceAndTimeShouldReturnTotalFare(){
        double totalFare = generator.calculateFare(5.0, 4);
        Assertions.assertEquals(54,totalFare);
    }

    @Test
    void givenDistanceAndTimeShouldReturnMinFare() {
        double totalFare = generator.calculateFare(0.1, 2);
        Assertions.assertEquals(5, totalFare);
    }

    @Test
    void givenMultipleRidesShouldReturnTotalFare(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,4,10);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,5,10);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        double totalFare = generator.calculateFare(rides);
        Assertions.assertEquals(150.0, totalFare);
    }
    @Test
    void givenMultipleRidesShouldReturnInvoice(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,4,10);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,5,10);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        Invoice actualInvoice = generator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3,150.0,50.0);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenUserIdShouldReturnInvoice(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE,4,10);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,5,10);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,3,10);
        Ride[] rides = new Ride[]{ride1,ride2,ride3};
        Customer customer = new Customer(1,rides);
        customer.rideList = rides;
//        customer.rideList.add(ride1);
//        customer.rideList.add(ride2);
//        customer.rideList.add(ride3);
        CabInvoiceGenerator.customerList.add(customer);
        Ride ride4 = new Ride(Ride.Category.NORMAL_RIDE,3,15);
        Ride[] rides1 = new Ride[]{ride4};
        Customer customer2 = new Customer(2,rides1);
        customer2.rideList = rides1;
//        customer2.rideList.add(ride4);
        CabInvoiceGenerator.customerList.add(customer2);
        Invoice actualInvoice = CabInvoiceGenerator.generateInvoice(1);
        Invoice expectedInvoice = new Invoice(3,150.0,50.0);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenUserIdShouldReturnTheInvoiceForRespectiveRides(){
        Ride ride1 = new Ride(Ride.Category.NORMAL_RIDE, 4,10);
        Ride ride2 = new Ride(Ride.Category.NORMAL_RIDE,5,10);
        Ride ride3 = new Ride(Ride.Category.NORMAL_RIDE,3,10);
        Ride[] rides1 = {ride1,ride2,ride3};

        Ride ride4 = new Ride(Ride.Category.PREMIUM_RIDE,8,4);
        Ride ride5 = new Ride(Ride.Category.PREMIUM_RIDE,6,3);
        Ride ride6 = new Ride(Ride.Category.PREMIUM_RIDE,0.2,1);
        Ride[] rides2 = {ride4,ride5,ride6};

        Customer customer1 = new Customer(1,rides1);
        Customer customer2 = new Customer(2,rides2);
        CabInvoiceGenerator.customerList.add(customer1);
        CabInvoiceGenerator.customerList.add(customer2);
        Invoice actualInvoice=CabInvoiceGenerator.generateInvoice(2);
        Invoice expectedInvoice = new Invoice(3,244.0,(244.0/3));
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

}
