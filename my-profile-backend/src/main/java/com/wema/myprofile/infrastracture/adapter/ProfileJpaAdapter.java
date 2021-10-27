package com.wema.myprofile.infrastracture.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wema.myprofile.domain.ProfileDomain;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;
import com.wema.myprofile.infrastracture.entity.Profile;
import com.wema.myprofile.infrastracture.mapper.ProfileMapper;
import com.wema.myprofile.infrastracture.repository.ProfileRepository;

@Service
public class ProfileJpaAdapter implements ProfilePersistencePort {

	private final ProfileRepository profileRepository;

	public ProfileJpaAdapter(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	public ProfileDomain addProfile(ProfileDomain profileDomain) {

		Profile profile = ProfileMapper.INSTANCE.profileDomainToProfile(profileDomain);
		Profile profileSaved = this.profileRepository.save(profile);
		return ProfileMapper.INSTANCE.profileToProfileDomain(profileSaved);
	}

	@Override
	public ProfileDomain updateProfile(ProfileDomain profileDomain) {
		return addProfile(profileDomain);
	}

	@Override
	public List<ProfileDomain> getProfiles() {

		List<Profile> profiles = this.profileRepository.findAll();
		return ProfileMapper.INSTANCE.profileListToProfileDomainList(profiles);
	}

	@Override
	public ProfileDomain getProfileById(Long profileId) {

		Optional<Profile> profile = this.profileRepository.findById(profileId);
		if (profile.isPresent()) {
			return ProfileMapper.INSTANCE.profileToProfileDomain(profile.get());
		}

		return null;
	}

}