package com.assesment.cycle.exception;

public class CycleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4555093107794198321L;

	public CycleNotFoundException(String message) {
		super(message);
	}
	
	public CycleNotFoundException() {
		super("Cycle not found for provided criteria.");
	}
	
}
