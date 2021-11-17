package com.wema.myprofile.infrastracture.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CERTIFICATION")
@Data
public class CertificationDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String organization;
	
	@Column(nullable = false)
	private LocalDate date;
	
	private String identifier;
	private String link;
	
	@ManyToOne 
	@JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;
}
