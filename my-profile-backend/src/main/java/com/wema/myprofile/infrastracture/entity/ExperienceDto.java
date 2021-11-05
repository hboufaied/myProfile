package com.wema.myprofile.infrastracture.entity;

import java.util.Date;

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

	@NotNull
	private String title;

	@Enumerated(EnumType.STRING)
	private JobType type;

	@NotNull
	private Date startDate;
	
	private Date endDate;
	private String description;

	@NotNull
    @OneToOne
    @JoinColumn(name="company_id")
	private CompanyDto company;
	
	@ManyToOne @JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;

}
