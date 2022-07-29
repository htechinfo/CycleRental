package com.assesment.cycle.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.cycle.entity.Cycle;
import com.assesment.cycle.exception.CycleNotFoundException;
import com.assesment.cycle.repository.CycleRepository;
import com.assesment.cycle.service.CycleService;

@Service
public class CycleServiceImpl implements CycleService {

	@Autowired
	private CycleRepository repository;
	
	@Override
	public Cycle createCycle(Cycle cycle) {
		return repository.save(cycle);
	}

	@Override
	public List<Cycle> getAllCycles() {
		return repository.findAll();
	}

	@Override
	public Cycle getCycleById(Integer cycleId) {
		Optional<Cycle> optionalCycle = repository.findById(cycleId);
		return optionalCycle.orElseThrow(CycleNotFoundException::new);
	}
}
