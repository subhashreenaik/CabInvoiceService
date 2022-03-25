package com.assignment.bridgelabz;

public class Ride {
	private double distance;
	private final int time;
	public String rideType;
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getTime() {
		return time;
	}
	public String getRideType() {
		return rideType;
	}
	public void setRideType(String rideType) {
		this.rideType = rideType;
	}
	public Ride(double distance, int time, String rideType) {
		super();
		this.distance = distance;
		this.time = time;
		this.rideType = rideType;
	}
	
}
