package com.assesment.cycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.cycle.constants.ReportTypes;
import com.assesment.cycle.entity.Customer;
import com.assesment.cycle.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController extends BaseController{

	@Autowired
	private ReportService reportService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getReport(@RequestParam ReportTypes reportType) {
		return new ResponseEntity<List<Customer>>(reportService.getReport(reportType), HttpStatus.OK);
	}
	
	@GetMapping("/generate")
	public ResponseEntity<HttpStatus> generateReports() {
		reportService.generateReports();
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
