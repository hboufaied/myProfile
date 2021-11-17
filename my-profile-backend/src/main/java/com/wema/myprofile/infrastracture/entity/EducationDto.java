package com.wema.myprofile.infrastracture.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EDUCATION")
@Data
public class EducationDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String school;
	
	@Column(nullable = false)
	private String studyLevel;
	
	@Column(nullable = false)
	private String studySpecialization;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	private LocalDate endDate;
	private String description;
	
	@ManyToOne 
	@JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;
}
