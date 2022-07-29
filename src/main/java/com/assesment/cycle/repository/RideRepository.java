package com.assesment.cycle.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.cycle.entity.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {
	List<Ride> findByCustomerId(Integer customerId);
	
	List<Ride> findByCycleId(Integer cycleId);
	
	Optional<Ride> findFirstByStartTimeBetweenOrderByDistanceTravelledDesc(LocalDateTime startTime, LocalDateTime endTime);
	
	Optional<Ride> findFirstByStartTimeBetweenOrderByCreationTimeAsc(LocalDateTime startTime, LocalDateTime endTime);
	
	Optional<Ride> findFirstByOrderByDistanceTravelledDesc();
	
	Optional<Ride> findFirstByOrderByStartTimeAsc();
	
	Optional<Ride> findFirstByOrderByTotalTimeTravelledDesc();
}
