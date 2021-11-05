package com.wema.myprofile.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.wema.myprofile.ProfileProvider;
import com.wema.myprofile.configuration.ProfileConfiguration;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hamcrest.Matchers;

@WebMvcTest(ProfileController.class)
@ContextConfiguration(classes = { ProfileModelAssembler.class })
class ProfileContyrollerTest {

	@MockBean
	ProfileServicePort profileService;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		RestAssuredMockMvc.mockMvc(mockMvc);
	}

	//@Test
	void shouldCreateNewProfileWhenDataIsValid() {

		Profile profile = ProfileProvider.getCreatedProfile();
		when(profileService.addProfile(any(Profile.class))).thenReturn(profile);

		RestAssuredMockMvc.given().contentType("application/json").body("{}").when().post("/api/profiles").then().statusCode(201).header("Location", Matchers.containsString("/api/books/42"));
	}

	/*@Test
	void shouldRetreiveAllProfiles() {

		when(profileService.getProfiles()).thenReturn(List.of(ProfileProvider.getCreatedProfile()));

		RestAssuredMockMvc.when().get("/api/profiles").then().statusCode(200).body("$.size()", Matchers.equalTo(1))
				.body("[0].id", Matchers.equalTo(42)).body("[0].isbn", Matchers.equalTo("42"))
				.body("[0].author", Matchers.equalTo("Duke"))
				.body("[0].title", Matchers.equalTo("REST Assured With Spring Boot"));
	}*/
}
