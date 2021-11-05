package com.wema.myprofile.infrastracture.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TRAINING")
@Data
public class TrainingDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String title;
	private String description;
	private Date date;
	
	@ManyToOne @JoinColumn(name="profile_id", nullable=false)
    private ProfileDto profile;
}
