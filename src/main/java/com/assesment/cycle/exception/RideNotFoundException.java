package com.assesment.cycle.exception;

public class RideNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8371065071441202873L;

	public RideNotFoundException(String message) {
		super(message);
	}
	
	public RideNotFoundException() {
		super("Ride not found for provided criteria.");
	}
}
