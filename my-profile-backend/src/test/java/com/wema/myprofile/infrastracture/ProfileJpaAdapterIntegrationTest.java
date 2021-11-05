package com.wema.myprofile.infrastracture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import com.wema.myprofile.ProfileProvider;
import com.wema.myprofile.configuration.ProfileConfiguration;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;

@DataJpaTest
@Import(ProfileConfiguration.class)
class ProfileJpaAdapterIntegrationTest {

	@Autowired
	ProfilePersistencePort profilePersistencePort;

	@DisplayName("Test create and save new profile with integration ")
	@Test
	void shouldSaveProfileInDataBaseWhenValidData() {

		Profile profile = ProfileProvider.getCreatedProfile();
		Profile profileSaved = profilePersistencePort.addProfile(profile);
		assertThat(profileSaved).isNotNull().usingRecursiveComparison().ignoringFieldsMatchingRegexes(".*id")
				.isEqualTo(profile);

	}

	@DisplayName("Test create and save new profile return an excpetion ")
	@Test
	void shouldReturnExcpetionWhenNotValidData() {

		Profile profile = Profile.builder().lastName("last name").build();

		DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
			profilePersistencePort.addProfile(profile);
		});
		assertThat(exception).isInstanceOf(DataIntegrityViolationException.class);
		assertThat(exception.getMessage())
				.containsIgnoringCase("not-null property references a null or transient value");

	}
}
