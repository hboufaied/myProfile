package com.wema.myprofile.infrastracture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Entity
@Table(name = "SKILL")
@Data
public class SkillDto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String label;
	
	private String description;
	
	@Min(1)
    @Max(10)
	private int expertiseLevel;
	
	@ManyToOne 
	@JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;
}
