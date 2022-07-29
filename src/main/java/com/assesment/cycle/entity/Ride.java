package com.assesment.cycle.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "`ride`")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "ride_sequence", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@Column(name = "`id`", nullable = false, unique = true)
    private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	@JsonIgnore
	@NonNull
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cycleId")
	@JsonIgnore
	@NonNull
	private Cycle cycle;
	
	@Column(name = "`start_time`", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@NonNull
	private LocalDateTime startTime;
	
	@Column(name = "`end_time`")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime endTime;
	
	@Column
	private Integer distanceTravelled = 0;
	
	@Column
	@JsonIgnore
	// Time is in seconds
	private long totalTimeTravelled = 0;
	
	@Column(name = "`creation_time`")
	private LocalDateTime creationTime = LocalDateTime.now();
}
