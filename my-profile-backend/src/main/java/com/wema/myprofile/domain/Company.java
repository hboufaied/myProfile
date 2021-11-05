package com.wema.myprofile.domain;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

	private Long id;
	
	@NotNull
	private String name;
	
	private Address address;

}
