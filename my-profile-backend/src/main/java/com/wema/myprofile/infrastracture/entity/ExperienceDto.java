package com.wema.myprofile.infrastracture.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "EXPERIENCE")
@Data
public class ExperienceDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Enumerated(EnumType.STRING)
	private JobType type;

	@Column(nullable = false)
	private LocalDate startDate;
	
	private LocalDate endDate;
	private String description;

	@NotNull
    @OneToOne
    @JoinColumn(name="company_id")
	private CompanyDto company;
	
	@ManyToOne @JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;

}
