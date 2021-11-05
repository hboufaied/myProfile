package com.wema.myprofile.infrastracture.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;
import com.wema.myprofile.infrastracture.entity.ProfileDto;
import com.wema.myprofile.infrastracture.mapper.ProfileMapper;
import com.wema.myprofile.infrastracture.repository.ProfileRepository;

public class ProfileJpaAdapter implements ProfilePersistencePort {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile addProfile(Profile profile) {

		ProfileDto profileDto = ProfileMapper.INSTANCE.profileToProfileDto(profile);
		ProfileDto profileSaved = this.profileRepository.save(profileDto);
		return ProfileMapper.INSTANCE.profileDtoToProfile(profileSaved);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return addProfile(profile);
	}

	@Override
	public List<Profile> getProfiles() {

		List<ProfileDto> profilesDto = this.profileRepository.findAll();
		return ProfileMapper.INSTANCE.profileDtoListToProfileList(profilesDto);
	}

	@Override
	public Profile getProfileById(Long profileId) {

		Optional<ProfileDto> profileDto = this.profileRepository.findById(profileId);
		if (profileDto.isPresent()) {
			return ProfileMapper.INSTANCE.profileDtoToProfile(profileDto.get());
		}

		return null;
	}

}