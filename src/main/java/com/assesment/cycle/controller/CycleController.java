package com.assesment.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.cycle.entity.Cycle;
import com.assesment.cycle.service.CycleService;

@RestController
@RequestMapping(path = "/cycle")
public class CycleController extends BaseController {
	@Autowired
	private CycleService cycleService;

	@GetMapping
	public ResponseEntity<List<Cycle>> getAllCycle() {
		return new ResponseEntity<List<Cycle>>(cycleService.getAllCycles(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cycle> createCycle(@Validated @RequestBody Cycle cycle) {
		return new ResponseEntity<Cycle>(cycleService.createCycle(cycle), HttpStatus.CREATED);
	}

}
