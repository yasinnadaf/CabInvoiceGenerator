package com.bridgelabz.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    @Test
    void givenDistanceAndTimeShouldReturnTotalFare(){
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(5.0, 4);
        Assertions.assertEquals(54,totalFare);
    }

    @Test
    void givenDistanceAndTimeShouldReturnMinFare() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double totalFare = generator.calculateFare(0.1, 2);
        Assertions.assertEquals(5, totalFare);
    }
}
