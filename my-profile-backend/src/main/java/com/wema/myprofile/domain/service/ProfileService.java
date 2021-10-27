package com.wema.myprofile.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wema.myprofile.domain.ProfileDomain;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;

@Service
public class ProfileService implements ProfileServicePort {

	private final ProfilePersistencePort profilePersistencePort;

	public ProfileService(ProfilePersistencePort profilePersistencePort) {
		this.profilePersistencePort = profilePersistencePort;
	}

	@Override
	public ProfileDomain addProfile(ProfileDomain profile) {
		return profilePersistencePort.addProfile(profile);
	}

	@Override
	public ProfileDomain updateProfile(ProfileDomain profile) {
		return profilePersistencePort.updateProfile(profile);
	}

	@Override
	public List<ProfileDomain> getProfiles() {
		return profilePersistencePort.getProfiles();
	}

	@Override
	public ProfileDomain getProfileById(Long profileId) {
		return profilePersistencePort.getProfileById(profileId);
	}

}
