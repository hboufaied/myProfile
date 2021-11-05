package com.wema.myprofile.application;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wema.myprofile.application.exception.ProfileNotFoundException;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

	private final ProfileServicePort profileService;
	private final ProfileModelAssembler assembler;

	public ProfileController(ProfileServicePort profileService, ProfileModelAssembler assembler) {
		this.profileService = profileService;
		this.assembler = assembler;
	}

	@PostMapping
	public ResponseEntity<EntityModel<Profile>> addProfile(@Valid @RequestBody final Profile profile) {
		EntityModel<Profile> entityModel = assembler.toModel(this.profileService.addProfile(profile));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@PutMapping
	public ResponseEntity<EntityModel<Profile>> updateProfile(@Valid @RequestBody final Profile profile) {
		final Profile profileUpdated = this.profileService.updateProfile(profile);
		EntityModel<Profile> entityModel = assembler.toModel(profileUpdated);

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@Operation(summary = "Get a profile by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found a profile", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Profile.class)) }),
			@ApiResponse(responseCode = "404", description = "Profile not found", content = @Content) })
	@GetMapping(value = "/{id}")
	public EntityModel<Profile> getProfileByID(
			@Parameter(description = "id of profile to be searched") @PathVariable final long id) {
		Profile profile = this.profileService.getProfileById(id);
		if (profile == null) {
			throw new ProfileNotFoundException(id);
		}
		return assembler.toModel(profile);
	}

	@GetMapping
	public CollectionModel<EntityModel<Profile>> getAllProfiles() {
		List<EntityModel<Profile>> employees = this.profileService.getProfiles().stream().map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(employees, linkTo(methodOn(ProfileController.class).getAllProfiles()).withSelfRel());
	}
}
