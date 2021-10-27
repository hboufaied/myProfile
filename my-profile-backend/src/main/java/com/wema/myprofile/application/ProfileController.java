package com.wema.myprofile.application;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wema.myprofile.domain.ProfileDomain;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

	private final ProfileServicePort profileService;

	public ProfileController(ProfileServicePort profileService) {
		this.profileService = profileService;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProfileDomain addBook(@RequestBody ProfileDomain profileDomain) {
		return this.profileService.addProfile(profileDomain);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProfileDomain updateBook(@RequestBody ProfileDomain profileDomain) {
		return this.profileService.updateProfile(profileDomain);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfileDomain getBookByID(@PathVariable long id) {
		return this.profileService.getProfileById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfileDomain> getAllProfiles() {
		return this.profileService.getProfiles();
	}
}
