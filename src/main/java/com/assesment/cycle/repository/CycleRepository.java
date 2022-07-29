package com.assesment.cycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.cycle.entity.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Integer> {

}
