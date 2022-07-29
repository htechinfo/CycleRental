package com.assesment.cycle.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assesment.cycle.exception.CustomerNotFoundException;
import com.assesment.cycle.exception.CycleNotFoundException;
import com.assesment.cycle.exception.RideNotFoundException;

public class BaseController {
	
	@ExceptionHandler(value = CycleNotFoundException.class)
    public ResponseEntity<String> handleCycleNotFoundException(CycleNotFoundException cycleNotFoundException) {
        return new ResponseEntity<String>(cycleNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException) {
        return new ResponseEntity<String>(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(value = RideNotFoundException.class)
    public ResponseEntity<String> handleRideNotFoundException(RideNotFoundException rideNotFoundException) {
        return new ResponseEntity<String>(rideNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException integrityConstraintViolationException) {
        return new ResponseEntity<String>(integrityConstraintViolationException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
