package com.wema.myprofile.infrastracture.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "EDUCATION")
@Data
public class EducationDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String school;
	
	@NotNull
	private String studyLevel;
	
	@NotNull
	private String studySpecialization;
	
	@NotNull
	private Date startDate;
	
	private Date endDate;
	private String description;
	
	@ManyToOne @JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;
}
