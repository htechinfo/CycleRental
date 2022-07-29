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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "`cycle`")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "cycle_sequence", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cycle {
	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@Column(name = "`id`", nullable = false, unique = true)
    private int id;
	
	@Column(name = "`brand`")
	@NonNull
	private String brand;
	
	@OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL)
	@Nullable
	private List<Ride> rides;
	
	@Column(name = "`creation_time`")
	private LocalDateTime creationTime = LocalDateTime.now();
}
