package com.assesment.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.cycle.entity.Ride;
import com.assesment.cycle.service.RideService;

@RestController
@RequestMapping("/ride")
public class RideController extends BaseController {

	@Autowired
	private RideService rideService;

	@GetMapping
	public ResponseEntity<List<Ride>> getAllRides() {
		return new ResponseEntity<List<Ride>>(rideService.getAllRides(), HttpStatus.OK);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Ride>> getRidesByCustomerId(@PathVariable Integer customerId) {
		return new ResponseEntity<List<Ride>>(rideService.getAllRidesByCustomerId(customerId), HttpStatus.OK);
	}

	@GetMapping("/cycle/{cycleId}")
	public ResponseEntity<List<Ride>> getRidesByCycleId(@PathVariable Integer cycleId) {
		return new ResponseEntity<List<Ride>>(rideService.getAllRidesByCycleId(cycleId), HttpStatus.OK);
	}

	@GetMapping("/{rideId}")
	public ResponseEntity<Ride> getRideByRideId(@PathVariable Integer rideId) {
		return new ResponseEntity<Ride>(rideService.getRideByRideId(rideId), HttpStatus.OK);
	}

	@PostMapping("/customer/{customerId}/cycle/{cycleId}")
	public ResponseEntity<Ride> createRide(@PathVariable Integer customerId, @PathVariable Integer cycleId,
			@Validated @RequestBody Ride ride) {
		return new ResponseEntity<Ride>(rideService.createRide(customerId, cycleId, ride), HttpStatus.CREATED);
	}

	@PutMapping("/{rideId}")
	public ResponseEntity<Ride> updateRide(@Validated @RequestBody Ride ride, @PathVariable Integer rideId) {
		return new ResponseEntity<Ride>(rideService.updateRide(rideId, ride), HttpStatus.ACCEPTED);
	}

}
