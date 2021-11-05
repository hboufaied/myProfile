package com.wema.myprofile.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wema.myprofile.domain.port.spi.ProfilePersistencePort;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;
import com.wema.myprofile.domain.service.ProfileService;
import com.wema.myprofile.infrastracture.adapter.ProfileJpaAdapter;

@Configuration
public class ProfileConfiguration {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

	@Bean
	public ProfilePersistencePort profilePersistence() {
		return new ProfileJpaAdapter();
	}

	@Bean
	public ProfileServicePort profileService() {
		return new ProfileService(profilePersistence());
	}
}
