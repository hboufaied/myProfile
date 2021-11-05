package com.wema.myprofile.domain.port.spi;

import java.util.List;

import com.wema.myprofile.domain.Profile;

public interface ProfilePersistencePort {
	
	Profile addProfile(Profile profile);

	Profile updateProfile(Profile profile);

	List<Profile> getProfiles();

	Profile getProfileById(Long profileId);
}
