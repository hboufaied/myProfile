package com.wema.myprofile.infrastracture.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PROFILE")
@Data
public class ProfileDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private Date birthDate;

	@Column(nullable = false)
	private String profileTitle;

	private String expertise;
	private String summary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private AddressDto address;

	@OneToMany(targetEntity = ExperienceDto.class, mappedBy = "profile")
	List<ExperienceDto> experiences;

	@OneToMany(targetEntity = EducationDto.class, mappedBy = "profile")
	List<EducationDto> educations;

	@OneToMany(targetEntity = CertificationDto.class, mappedBy = "profile")
	List<CertificationDto> certifications;

	@OneToMany(targetEntity = TrainingDto.class, mappedBy = "profile")
	List<TrainingDto> trainings;

	@OneToMany(targetEntity = SkillDto.class, mappedBy = "profile")
	List<SkillDto> skills;

}
