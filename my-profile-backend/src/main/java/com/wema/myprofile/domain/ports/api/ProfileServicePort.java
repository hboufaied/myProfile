package com.wema.myprofile.domain.ports.api;

import java.util.List;

import com.wema.myprofile.domain.ProfileDomain;

public interface ProfileServicePort {

	ProfileDomain addProfile(ProfileDomain profile);

	ProfileDomain updateProfile(ProfileDomain profile);

	List<ProfileDomain> getProfiles();

	ProfileDomain getProfileById(Long profileId);

}
