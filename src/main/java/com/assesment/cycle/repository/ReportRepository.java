package com.assesment.cycle.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.cycle.constants.ReportTypes;
import com.assesment.cycle.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	Optional<Report> findByReportTypeAndCreationDate(ReportTypes reportType, LocalDate creationDate);
	
	List<Report> findFirst7ByReportTypeOrderByCreationDateDesc(ReportTypes reportType);
}
