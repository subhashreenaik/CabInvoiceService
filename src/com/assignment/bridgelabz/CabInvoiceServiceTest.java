package com.assignment.bridgelabz;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

class CabInvoiceServiceTest {
	
	static InvoiceGenerator invoiceGenerator;

    @BeforeClass
    public static void start(){
        invoiceGenerator = new InvoiceGenerator();
        System.out.println("Welcome to cab invoice generator problem");
    }
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare(){
        double distance=2;
        int time=5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        System.out.println("Total Fare is:"+fare);
        Assert.assertEquals(25.0,fare,0.0);
    }
    @Test
	public void whenGivenMultipleRidesShouldReturnTotalFare() {
	Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1)};
	InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
	double totalFare = invoiceGenerator.calculateTotalFare(rides);
	System.out.println("Total Fare = "+totalFare);
    Assert.assertEquals(30, totalFare,0.0);
	}

}
