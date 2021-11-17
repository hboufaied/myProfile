package com.wema.myprofile.application;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import com.wema.myprofile.ProfileProvider;
import com.wema.myprofile.application.exception.ProfileExceptionsHandler;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.domain.ports.api.ProfileServicePort;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(ProfileController.class)
@ContextConfiguration(classes = { ProfileModelAssembler.class })
class ProfileControllerTest {

	@Mock
	private ProfileServicePort profileService;

	private ProfileController profileController;

	@InjectMocks
	private ProfileExceptionsHandler profileExceptionsHandler;

	@InjectMocks
	private ProfileModelAssembler profileModelAssembler;

	@BeforeEach
	void setUp() {
		profileController = new ProfileController(profileService, profileModelAssembler);
		RestAssuredMockMvc.standaloneSetup(profileController, profileExceptionsHandler);
	}

	@AfterEach
	public void resetRestAssuredMockMvcStandalone() {
		Mockito.reset(profileService);
	}

	@Test
	void shouldReturnBadRequestWhenCreateProfileWhithInvalidData() {
		given()
			.contentType("application/json").body("{}").
		when()
			.post("/api/profiles").
		then()
			.log().ifValidationFails()
			.statusCode(BAD_REQUEST.value()).contentType(JSON)
			.body("errors.size()", equalTo(4))
			.body("errors.firstName", equalTo("First name can't be blank"))
			.body("errors.lastName", equalTo("Last name can't be blank"))
			.body("errors.profileTitle", equalTo("Profile title can't be blank"))
			.body("errors.birthDate", equalTo("The date of birth can't be blank"));
	}

	@Test
	void shouldReturnBadRequestWhenCreateProfileWhithDateOfBithNotInThePast() {

		Profile profile = ProfileProvider.getCreatedProfile();
		profile.setId(11L);
		profile.setBirthDate(LocalDate.of(2021, 11, 30));
		when(profileService.addProfile(any(Profile.class))).thenReturn(profile);

		given()
			.contentType("application/json").body(profile).
		when()
			.post("/api/profiles").
		then()
			.log().ifValidationFails()
			.statusCode(BAD_REQUEST.value())
			.contentType(JSON)
			.body("errors.size()", equalTo(1))
			.body("errors.birthDate", equalTo("The date of birth must be in the past."));
	}

	@Test
	void shouldReturnRessourceCreatedWhenCreateProfileWhithValidData() {

		Profile profile = ProfileProvider.getCreatedProfile();
		profile.setId(11L);
		when(profileService.addProfile(any(Profile.class))).thenReturn(profile);

		given()
			.contentType("application/json").body(profile).
		when()
			.post("/api/profiles").
		then()
			.log().ifValidationFails()
			.statusCode(CREATED.value())
			.contentType(JSON)
			.body("firstName", equalTo(profile.getFirstName()))
			.body("lastName", equalTo(profile.getLastName()))
			.body("profileTitle", equalTo(profile.getProfileTitle()))
			.body("address.city", equalTo(profile.getAddress().getCity()))
			.body("experiences[0].title", equalTo(profile.getExperiences().get(0).getTitle()))				
			.body("experiences[0].company.name", equalTo(profile.getExperiences().get(0).getCompany().getName()))
			.body("experiences[0].company.address.city",
						equalTo(profile.getExperiences().get(0).getCompany().getAddress().getCity()))
			.body("links[0].rel", equalTo("self"))
			.body("links[0].href", equalTo("http://localhost/api/profiles/11"))
			.body("links[1].rel", equalTo("/api/profiles"))
			.body("links[1].href", equalTo("http://localhost/api/profiles"));

	}
}
