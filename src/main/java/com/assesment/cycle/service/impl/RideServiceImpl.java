package com.assesment.cycle.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.cycle.entity.Customer;
import com.assesment.cycle.entity.Cycle;
import com.assesment.cycle.entity.Ride;
import com.assesment.cycle.exception.RideNotFoundException;
import com.assesment.cycle.repository.RideRepository;
import com.assesment.cycle.service.CustomerService;
import com.assesment.cycle.service.CycleService;
import com.assesment.cycle.service.RideService;

@Service
public class RideServiceImpl implements RideService {

	@Autowired
	private RideRepository repository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CycleService cycleService;
	
	@Override
	public Ride createRide(Integer customerId, Integer cycleId, Ride ride) {
		Customer customer = customerService.getCustomerById(customerId);
		Cycle cycle = cycleService.getCycleById(cycleId);
		ride.setCustomer(customer);
		ride.setCycle(cycle);
		return repository.save(ride);
	}

	@Override
	public Ride getRideByRideId(Integer rideId) {
		Optional<Ride> optionalRide = repository.findById(rideId);
		return optionalRide.orElseThrow(RideNotFoundException::new);
	}

	@Override
	public List<Ride> getAllRides() {
		return repository.findAll();
	}

	@Override
	public List<Ride> getAllRidesByCustomerId(Integer customerId) {
		return repository.findByCustomerId(customerId);
	}

	@Override
	public List<Ride> getAllRidesByCycleId(Integer cycleId) {
		return repository.findByCycleId(cycleId);
	}

	@Override
	public Ride updateRide(Integer rideId, Ride ride) {
		Ride r = getRideByRideId(rideId);
		if (r != null && r.getEndTime() == null) {
			r.setDistanceTravelled(ride.getDistanceTravelled());
			r.setEndTime(ride.getEndTime());
			r.setTotalTimeTravelled(r.getStartTime().until(r.getEndTime(), ChronoUnit.SECONDS));
			r = repository.save(r);
		}
		return r;
	}

}
