package com.wema.myprofile.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {

	private Long id;
	private String school;
	private String studyLevel;
	private String studySpecialization;
	private Date startDate;
	private Date endDate;
	private String description;
}
