package com.wema.myprofile.infrastracture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import com.wema.myprofile.ProfileProvider;
import com.wema.myprofile.configuration.ProfileConfiguration;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;
import com.wema.myprofile.infrastracture.adapter.ProfileJpaAdapter;
import com.wema.myprofile.infrastracture.entity.ProfileDto;
import com.wema.myprofile.infrastracture.mapper.ProfileMapper;
import com.wema.myprofile.infrastracture.repository.ProfileRepository;

@DataJpaTest
@Import(ProfileConfiguration.class)
class ProfileJpaAdapterTest {

	@Mock
	private ProfileRepository profileRepository;

	@InjectMocks
	private ProfilePersistencePort profilePersistencePort = new ProfileJpaAdapter();

	@DisplayName("Test create and save new profile with mock repository")
	@Test
	void shouldSaveNewProfileDtoUsingMockRepository() throws Exception {

		ProfileDto profileDto = ProfileProvider.getCreatedProfileDto();
		when(profileRepository.save(any(ProfileDto.class))).thenReturn(profileDto);

		Profile profile = ProfileMapper.INSTANCE.profileDtoToProfile(profileDto);
		Profile profileSaved = this.profilePersistencePort.addProfile(profile);

		verify(profileRepository).save(profileDto);
		assertThat(profileSaved).isNotNull().usingRecursiveComparison().isEqualTo(profile);
	}
}
