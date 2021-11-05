package com.wema.myprofile.infrastracture.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COMPANY")
@Data
public class CompanyDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
	private AddressDto address;

}
