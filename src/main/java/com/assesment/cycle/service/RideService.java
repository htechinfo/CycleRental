package com.assesment.cycle.service;

import java.util.List;

import com.assesment.cycle.entity.Ride;

public interface RideService {
	Ride createRide(Integer customerId, Integer cycleId, Ride ride);
	
	Ride updateRide(Integer rideId, Ride ride);
	
	Ride getRideByRideId(Integer rideId);
	
	List<Ride> getAllRides();
	
	List<Ride> getAllRidesByCustomerId(Integer customerId);
	
	List<Ride> getAllRidesByCycleId(Integer cycleId);
}
