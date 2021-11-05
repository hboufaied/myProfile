package com.wema.myprofile.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

	private Long id;
	
	@NotNull
	private String label;
	
	private String description;
	
	@Min(1)
    @Max(10)
	private int expertiseLevel;

}