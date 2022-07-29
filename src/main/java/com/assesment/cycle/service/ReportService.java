package com.assesment.cycle.service;

import java.util.List;

import com.assesment.cycle.constants.ReportTypes;
import com.assesment.cycle.entity.Customer;

public interface ReportService {
	void generateReports();
	
	List<Customer> getReport(ReportTypes reportType);
}
