package com.assignment.bridgelabz;

public class InvoiceGenerator {
	static double cost_per_kilometer = 10;
	static  int cost_per_minute = 1;
	
	public double calculateFare(double distance, int time) {
		return distance * cost_per_kilometer + time * cost_per_minute;
		
	}
	public double calculateTotalFare(Ride[] rides) {
		double totalFare =0;
		for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
	}
	
    public int getNumberOfRides(Ride[] rides) {
		
		return rides.length;
	}
    
    public double calculateAverageRideCost(Ride[] rides) {
	double totalFare=0;
	for(Ride ride:rides) {
		totalFare += calculateFare(ride.getDistance(), ride.getTime());
	  }
	 return totalFare / rides.length;
}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


	
}
}
