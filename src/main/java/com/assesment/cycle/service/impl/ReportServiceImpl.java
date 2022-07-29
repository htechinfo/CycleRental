package com.assesment.cycle.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.assesment.cycle.constants.ReportTypes;
import com.assesment.cycle.entity.Customer;
import com.assesment.cycle.entity.Report;
import com.assesment.cycle.entity.Ride;
import com.assesment.cycle.repository.ReportRepository;
import com.assesment.cycle.repository.RideRepository;
import com.assesment.cycle.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportRepository repository;
	
	@Autowired 
	private RideRepository rideRepository;

	@Override
	public List<Customer> getReport(ReportTypes reportType) {
		return repository.findFirst7ByReportTypeOrderByCreationDateDesc(reportType).stream().map(r -> r.getCustomer()).toList();
	}
	
	@Scheduled(cron = "${cron.report.generation.expression}")
	@Override
	public void generateReports() {
		// Generate for day wise highest distance traveler
		dayWiseHighestDistanceTraverlerReportGenerator();
		
		// Generate for day wise earliest distance traveler
		dayWiseEarliestTraverlerReportGenerator();
		
		// Generate for overall earliest distance traveler
		overAllEarliestTraverlerReportGenerator();
		
		// Generate for overall highest distance traveler
		overAllHighestDistanceTraverlerReportGenerator();
		
		// Generate for longest time traveler
		longestTimeTravelerReportGenerator();
	}

	private void dayWiseEarliestTraverlerReportGenerator() {
		Optional<Report>optionalReport = repository.findByReportTypeAndCreationDate(ReportTypes.DAY_WISE_EARLY_TRAVELER, LocalDate.now());
		if (!optionalReport.isPresent()) {
			LocalDate now = LocalDate.now();
			LocalDateTime yesterday = LocalDateTime.of(now.minusDays(1), LocalTime.MIDNIGHT);
			LocalDateTime today = LocalDateTime.of(now, LocalTime.MIDNIGHT);
			Optional<Ride> optionalRide = rideRepository.findFirstByStartTimeBetweenOrderByCreationTimeAsc(yesterday, today);
			if (optionalRide.isPresent()) {
				Report report = new Report();
				report.setCustomer(optionalRide.get().getCustomer());
				report.setReportType(ReportTypes.DAY_WISE_EARLY_TRAVELER);
				repository.save(report);
			}
		}
	}

	private void dayWiseHighestDistanceTraverlerReportGenerator() {
		Optional<Report> optionalReport = repository.findByReportTypeAndCreationDate(ReportTypes.DAY_WISE_HIGHEST_DISTANCE_TRAVELER, LocalDate.now());
		if (!optionalReport.isPresent()) {
			LocalDate now = LocalDate.now();
			LocalDateTime yesterday = LocalDateTime.of(now.minusDays(1), LocalTime.MIDNIGHT);
			LocalDateTime today = LocalDateTime.of(now, LocalTime.MIDNIGHT);
			Optional<Ride> optionalRide = rideRepository.findFirstByStartTimeBetweenOrderByDistanceTravelledDesc(yesterday, today);
			if (optionalRide.isPresent()) {
				Report report = new Report();
				report.setCustomer(optionalRide.get().getCustomer());
				report.setReportType(ReportTypes.DAY_WISE_HIGHEST_DISTANCE_TRAVELER);
				repository.save(report);
			}
		}
	}

	private void overAllHighestDistanceTraverlerReportGenerator() {
		Optional<Report> optionalReport = repository.findByReportTypeAndCreationDate(ReportTypes.OVERALL_HIGHEST_DISTANCE_TRAVELER, LocalDate.now());
		Report report = optionalReport.orElse(new Report());
		
		Optional<Ride> optionalRide = rideRepository.findFirstByOrderByDistanceTravelledDesc();
		if (optionalRide.isPresent()) {
			report.setCustomer(optionalRide.get().getCustomer());
			report.setReportType(ReportTypes.OVERALL_HIGHEST_DISTANCE_TRAVELER);
			report.setModificationDate(LocalDate.now());
			repository.save(report);
		}
	}

	private void overAllEarliestTraverlerReportGenerator() {
		Optional<Report> optionalReport = repository.findByReportTypeAndCreationDate(ReportTypes.OVERALL_EARLY_TRAVELER, LocalDate.now());
		Report report = optionalReport.orElse(new Report());
		
		Optional<Ride> optionalRide = rideRepository.findFirstByOrderByStartTimeAsc();
		if (optionalRide.isPresent()) {
			report.setCustomer(optionalRide.get().getCustomer());
			report.setReportType(ReportTypes.OVERALL_EARLY_TRAVELER);
			report.setModificationDate(LocalDate.now());
			repository.save(report);
		}
	}

	private void longestTimeTravelerReportGenerator() {
		Optional<Report> optionalReport = repository.findByReportTypeAndCreationDate(ReportTypes.LONGEST_TIME_TRAVELER, LocalDate.now());
		Report report = optionalReport.orElse(new Report());
		
		Optional<Ride> optionalRide = rideRepository.findFirstByOrderByTotalTimeTravelledDesc();
		if (optionalRide.isPresent()) {
			report.setCustomer(optionalRide.get().getCustomer());
			report.setReportType(ReportTypes.LONGEST_TIME_TRAVELER);
			report.setModificationDate(LocalDate.now());
			repository.save(report);
		}
	}
}
