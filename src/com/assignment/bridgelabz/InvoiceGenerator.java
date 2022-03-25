package com.assignment.bridgelabz;

public class InvoiceGenerator {
	static double cost_per_kilometer = 10;
	static  int cost_per_minute = 1;
	static int minimum_fare=5;
	RideRepository rideRepository;
	
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
    public InvoiceSummary calculateFare(Ride... rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			
			checkRideType(ride.rideType);
			totalFare += ride.getDistance() * cost_per_kilometer + ride.getTime() * cost_per_minute;
		}
		if (totalFare < minimum_fare)
			return new InvoiceSummary(rides.length, minimum_fare);
		return new InvoiceSummary(rides.length, totalFare);
	}
private void checkRideType(String rideType) {
		
		switch (rideType) {
		case "PREMIUM":
			cost_per_kilometer = 15;
			cost_per_minute = 2;
			minimum_fare = 20;
			break;
		case "NORMAL":
			cost_per_kilometer = 10;
			cost_per_minute = 1;
			minimum_fare = 5;
			break;
		}
	}

public InvoiceSummary invoiceForUser(String userId) {
	return calculateFare(rideRepository.getRidesForUser(userId));
}


public void addRideToRepository(String[] userId, Ride[][] rides) throws InvoiceGeneratorException {
	for (int i = 0; i < userId.length; i++) {
		rideRepository.addRideForUser(userId[i], rides[i]);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


	
}
}
