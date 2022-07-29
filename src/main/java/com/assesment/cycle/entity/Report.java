package com.assesment.cycle.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.assesment.cycle.constants.ReportTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`reports`")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "reports_sequence", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@Column(name = "`id`", nullable = false, unique = true)
    private int id;
	
	@Enumerated(EnumType.STRING)
	private ReportTypes reportType;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	@Column(name = "`creation_date`")
	private LocalDate creationDate = LocalDate.now();
	
	@Column(name = "`modification_date`")
	private LocalDate modificationDate = LocalDate.now();
}
