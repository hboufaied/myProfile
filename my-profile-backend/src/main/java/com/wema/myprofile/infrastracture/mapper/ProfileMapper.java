package com.wema.myprofile.infrastracture.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.wema.myprofile.domain.Address;
import com.wema.myprofile.domain.Certification;
import com.wema.myprofile.domain.Company;
import com.wema.myprofile.domain.Education;
import com.wema.myprofile.domain.Experience;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.Skill;
import com.wema.myprofile.domain.Training;
import com.wema.myprofile.infrastracture.entity.AddressDto;
import com.wema.myprofile.infrastracture.entity.CertificationDto;
import com.wema.myprofile.infrastracture.entity.CompanyDto;
import com.wema.myprofile.infrastracture.entity.EducationDto;
import com.wema.myprofile.infrastracture.entity.ExperienceDto;
import com.wema.myprofile.infrastracture.entity.ProfileDto;
import com.wema.myprofile.infrastracture.entity.SkillDto;
import com.wema.myprofile.infrastracture.entity.TrainingDto;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

	ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

	ProfileDto profileToProfileDto(Profile profile);

	Profile profileDtoToProfile(ProfileDto profileDto);

	List<ProfileDto> profileListToProfileDtoList(List<Profile> profiles);

	List<Profile> profileDtoListToProfileList(List<ProfileDto> profilesDto);

	AddressDto addressToAddressDto(Address address);

	Address addressDtoToAddress(AddressDto addressDto);

	CompanyDto companyToCompanyDto(Company company);

	Company companyDtoToCompany(CompanyDto companyDto);

	ExperienceDto experienceToExperienceDto(Experience experience);

	Experience experienceDtoToExperience(ExperienceDto experienceDto);

	EducationDto educationToEducationDto(Education education);

	Education educationDtoToEducation(EducationDto educationDto);

	CertificationDto certificationToCertificationDto(Certification certification);

	Certification certificationDtoToCertification(CertificationDto certificationDto);

	TrainingDto trainingToTrainingDto(Training training);

	Training trainingDtoToTraining(TrainingDto trainingDto);

	SkillDto skillToSkillDto(Skill skill);

	Skill skillDomainToSkill(SkillDto skillDto);
}
