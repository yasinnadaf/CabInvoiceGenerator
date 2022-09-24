package com.bridgelabz.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
//        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(5.0, 4);
        Assertions.assertEquals(54,totalFare);
    }

    @Test
    void givenDistanceAndTimeShouldReturnMinFare() {
//        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(0.1, 2);
        Assertions.assertEquals(5, totalFare);
    }

    @Test
    void givenMultipleRidesShouldReturnAggregateTotalFare(){
        Ride[] rides = {new Ride(1.0, 5),
                new Ride(0.2, 2)};

        double totalFare = generator.calculateFare(rides);
        Assertions.assertEquals(20, totalFare);

    }
}
