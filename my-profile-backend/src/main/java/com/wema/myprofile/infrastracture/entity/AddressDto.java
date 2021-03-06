package com.wema.myprofile.infrastracture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class AddressDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String region;
	
	@Column(nullable = false)
	private String country;
}
