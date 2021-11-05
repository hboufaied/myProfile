package com.wema.myprofile.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.wema.myprofile.ProfileProvider;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;

class ProfileServiceTest {

	private ProfilePersistencePort profilePersistencePort;
	private ProfileService profileService;

	@BeforeEach
	void setUp() {
		profilePersistencePort = mock(ProfilePersistencePort.class);
		profileService = new ProfileService(profilePersistencePort);
	}

	@DisplayName("Test create and save a new profile")
	@Test
	void shouldCreateProfile_thenSaveIt() {
		final Profile profile = ProfileProvider.getCreatedProfile();
		when(profilePersistencePort.addProfile(any(Profile.class))).thenReturn(profile);

		final Profile profileSaved = profileService.addProfile(profile);

		verify(profilePersistencePort).addProfile(profile);
		assertThat(profileSaved).isNotNull().usingRecursiveComparison().ignoringFieldsMatchingRegexes(".*id")
				.isEqualTo(profile);
		;
	}

}