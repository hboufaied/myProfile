package com.wema.myprofile.application;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.wema.myprofile.domain.Profile;

@Component
public class ProfileModelAssembler implements RepresentationModelAssembler<Profile, EntityModel<Profile>> {

	@Override
	public EntityModel<Profile> toModel(Profile profile) {
		return EntityModel.of(profile,
				linkTo(methodOn(ProfileController.class).getProfileByID(profile.getId())).withSelfRel(),
				linkTo(methodOn(ProfileController.class).getAllProfiles()).withRel("/api/profiles"));
	}

}
