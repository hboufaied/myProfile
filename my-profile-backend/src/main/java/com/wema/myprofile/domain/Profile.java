package com.wema.myprofile.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

	private Long id;
	
	@NotBlank(message = "First name can't be blank")
	private String firstName;
	
	@NotBlank(message = "Last name can't be blank")
	private String lastName;
	
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull(message = "The date of birth can't be blank")
    @Past(message = "The date of birth must be in the past.")
	private Date birthDate;
	
	@NotBlank(message = "Profile title can't be blank")
	private String profileTitle;
	private String expertise;
	private String summary;

	private Address address;
	List<Experience> experiences;
	List<Education> educations;
	List<Certification> certifications;
	List<Training> trainings;
	List<Skill> skills;
}
