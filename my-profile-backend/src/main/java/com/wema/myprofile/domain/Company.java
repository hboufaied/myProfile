package com.wema.myprofile.domain;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private Long id;
	
	@NotNull
	private String name;
	
	private Address address;

}
