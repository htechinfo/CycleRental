package com.assesment.cycle.service;

import java.util.List;

import com.assesment.cycle.entity.Cycle;

public interface CycleService {
	Cycle createCycle(Cycle cycle);
	
	List<Cycle> getAllCycles();
	
	Cycle getCycleById(Integer cycleId);
}
