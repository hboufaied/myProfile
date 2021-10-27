package com.wema.myprofile.infrastracture.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wema.myprofile.domain.ProfileDomain;
import com.wema.myprofile.infrastracture.entity.Profile;

@Mapper
public interface ProfileMapper {

	ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

	ProfileDomain profileToProfileDomain(Profile profile);

	Profile profileDomainToProfile(ProfileDomain profileDomain);

	List<ProfileDomain> profileListToProfileDomainList(List<Profile> profiles);

	List<Profile> profileDomainListToProfileList(List<ProfileDomain> profilesDomain);
}
