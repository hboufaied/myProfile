package com.wema.myprofile.domain.ports.api;

import java.util.List;

import com.wema.myprofile.domain.Profile;

public interface ProfileServicePort {

	Profile addProfile(Profile profile);

	Profile updateProfile(Profile profile);

	List<Profile> getProfiles();

	Profile getProfileById(Long profileId);

}
