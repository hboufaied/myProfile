package com.wema.myprofile.domain.port.spi;

import java.util.List;

import com.wema.myprofile.domain.ProfileDomain;

public interface ProfilePersistencePort {
	
	ProfileDomain addProfile(ProfileDomain profile);

	ProfileDomain updateProfile(ProfileDomain profile);

	List<ProfileDomain> getProfiles();

	ProfileDomain getProfileById(Long profileId);
}
