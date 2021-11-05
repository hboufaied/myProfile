package com.wema.myprofile.domain.service;

import java.util.List;

import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;

public class ProfileService implements ProfileServicePort {

	private final ProfilePersistencePort profilePersistencePort;

	public ProfileService(ProfilePersistencePort profilePersistencePort) {
		this.profilePersistencePort = profilePersistencePort;
	}

	@Override
	public Profile addProfile(Profile profile) {
		return profilePersistencePort.addProfile(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return profilePersistencePort.updateProfile(profile);
	}

	@Override
	public List<Profile> getProfiles() {
		return profilePersistencePort.getProfiles();
	}

	@Override
	public Profile getProfileById(Long profileId) {
		return profilePersistencePort.getProfileById(profileId);
	}

}
