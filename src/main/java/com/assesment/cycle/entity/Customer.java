package com.assesment.cycle.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "`customer`")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "customer_sequence", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Customer {
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@Column(name = "`id`", nullable = false, unique = true)
    private int id;
	
	@Column(nullable = false)
	@NonNull
	private String name;
	
	@Column(unique = true, nullable = false)
	@NonNull
	private String emailAddress;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Report> report;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@Nullable
	private List<Ride> rides;
	
	@Column(name = "`creation_time`")
	private LocalDateTime creationTime = LocalDateTime.now();
}
