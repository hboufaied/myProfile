package com.wema.myprofile.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Training {

	private Long id;
	
	@NotNull
	private String title;
	
	private String description;
	
	@NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
	private Date date;

}
