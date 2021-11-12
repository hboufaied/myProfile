package com.wema.myprofile;

import java.util.Date;
import java.util.List;

import com.wema.myprofile.domain.Address;
import com.wema.myprofile.domain.Company;
import com.wema.myprofile.domain.Experience;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.infrastracture.entity.AddressDto;
import com.wema.myprofile.infrastracture.entity.CompanyDto;
import com.wema.myprofile.infrastracture.entity.ExperienceDto;
import com.wema.myprofile.infrastracture.entity.JobType;
import com.wema.myprofile.infrastracture.entity.ProfileDto;

public class ProfileProvider {

	public static Profile getCreatedProfile() {

		Address addressProfile = Address.builder().city("Bougival").region("Ile de France").country("France").build();
		Address addressCompany = Address.builder().city("Paris 7").region("Ile de France").country("France").build();
		Company company = Company.builder().name("Wema").address(addressCompany).build();
		Experience experience = Experience.builder().title("Tech Lead").type("FULL_TIME").company(company).build();

		Profile profile = Profile.builder().firstName("Hamda").lastName("Hamda").birthDate(new Date())
				.profileTitle("Developper").address(addressProfile).experiences(List.of(experience)).build();

		return profile;
	}

	public static ProfileDto getCreatedProfileDto() {

		AddressDto addressProfile = new AddressDto();
		addressProfile.setId(1L);
		addressProfile.setCity("Bougival");
		addressProfile.setRegion("Ile de France");
		addressProfile.setCountry("France");

		AddressDto addressCompany = new AddressDto();
		addressCompany.setId(2L);
		addressCompany.setCity("Paris 7");
		addressCompany.setRegion("Ile de France");
		addressCompany.setCountry("France");

		CompanyDto company = new CompanyDto();
		company.setId(1L);
		company.setName("Wema");
		company.setAddress(addressCompany);

		ExperienceDto experience = new ExperienceDto();
		experience.setId(1L);
		experience.setTitle("Tech Lead");
		experience.setType(JobType.FULL_TIME);
		experience.setCompany(company);

		ProfileDto profile = new ProfileDto();
		profile.setId(1L);
		profile.setFirstName("Hamda");
		profile.setLastName("Hamda");
		profile.setBirthDate(new Date());
		profile.setProfileTitle("Developper");
		profile.setAddress(addressProfile);
		profile.setExperiences(List.of(experience));
		;

		return profile;
	}
}
