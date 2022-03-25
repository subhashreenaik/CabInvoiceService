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
    /**
	 * Test method to calculate total fare of the ride by given distance and time as
	 * the input parameters
	 */
    @Test
    public void totalFare(){
        double distance=2;
        int time=5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        System.out.println("Total Fare is:"+fare);
        Assert.assertEquals(25.0,fare,0.0);
    }

	/**
	 * Method to calculate total fare for multiple rides
	 */
//    @Test
//	public void totalFareOfMultipleRides() {
//	Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1)};
//	InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
//	double totalFare = invoiceGenerator.calculateTotalFare(rides);
//	System.out.println("Total Fare = "+totalFare);
//    Assert.assertEquals(30, totalFare,0.0);
//	}
    
//    @Test
//    public void sizeAndAverageFare_of_Multiplerides(){
//        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
//
//        Ride[] rides = { new Ride(20.0,4),
//                         new Ride(45.0,1),
//                         new Ride(75.0,1),
//                         new Ride(45.5,1)};
//
//        double totalFare = invoiceGenerator.calculateTotalFare(rides);
//        int numberOfRides = invoiceGenerator.getNumberOfRides(rides);
//        double averageTotalFare = invoiceGenerator.calculateAverageRideCost(rides);
//
//        System.out.println("Total Fare = " +totalFare);
//        System.out.println("Number of ride = " +numberOfRides);
//        System.out.println("Average Total Fare " +averageTotalFare);
//
//        Assert.assertEquals(1862,totalFare,0.0);
//        Assert.assertEquals(4,numberOfRides);
//        Assert.assertEquals(465,averageTotalFare,0.5);
//	}
    
	

	

	@Test
	public void whenGivenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(3.0, 7, "NORMAL"), new Ride(0.01, 1, "NORMAL") };
		InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(rides.length, 38.1);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	

	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException {
		String[] userId = { "user1", "user2", "user3" };
		Ride[][] rides = { { new Ride(5.0, 12, "NORMAL"), new Ride(2.5, 6, "NORMAL") },
				{ new Ride(3.0, 5, "NORMAL"), new Ride(0.01, 1, "NORMAL") },
				{ new Ride(10.0, 15, "NORMAL"), new Ride(2, 30, "NORMAL") } };
		invoiceGenerator.addRideToRepository(userId, rides);
		InvoiceSummary summary = invoiceGenerator.invoiceForUser(userId[2]);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(rides[2].length, 165.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

}
    

