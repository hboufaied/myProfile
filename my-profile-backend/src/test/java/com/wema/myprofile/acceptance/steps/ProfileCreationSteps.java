package com.wema.myprofile.acceptance.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import org.hamcrest.Matchers;
import org.mockito.internal.matchers.Contains;
import org.springframework.beans.factory.annotation.Autowired;

import com.wema.myprofile.ProfileProvider;
import com.wema.myprofile.acceptance.common.ScenarioContextApi;
import com.wema.myprofile.domain.Profile;
import com.wema.myprofile.infrastracture.entity.ProfileDto;
import com.wema.myprofile.infrastracture.repository.ProfileRepository;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.containsString;

@Slf4j
public class ProfileCreationSteps {

	@Autowired
	private ScenarioContextApi context;

	@When("^I make a GET call on ([^\"]*)$")
	public void iMakeAGETCallOn(String path) {
		context.invokeHttpGet(path);
	}

	@When("^I make a Post call on ([^\"]*)$")
	public void iMakeAPOSTCallOn(String path) {
		Profile profile = Profile.builder().build();
		context.invokeHttpPost(path, profile);
	}

	@Then("^I should receive (\\d+) response status code$")
	public void iShouldReceiveStatusCodeResponse(int code) {
		context.response.then().statusCode(code);
	}

	@Then("^I should receives the detail of errors$")
	public void shouldReceiveAnErrorBody() {
		context.response.then().body("errors.size()", equalTo(4))
		.body("errors.firstName", equalTo("First name can't be blank"))
		.body("errors.lastName", equalTo("Last name can't be blank"))
		.body("errors.profileTitle", equalTo("Profile title can't be blank"))
		.body("errors.birthDate", equalTo("The date of birth can't be blank"));
	}
	
	@When("^I add a new valid profile on ([^\\\"]*)$")
	public void iAddANewValidProfile(String path) {
		Profile profile = ProfileProvider.getCreatedProfile();
		context.invokeHttpPost(path, profile);
	}
	
	@Then("^the profile is created$")
	public void shouldReceiveProfileBody() {
		context.response.then().body("firstName", notNullValue())
		.body("lastName", notNullValue())
		.body("profileTitle", notNullValue())
		.body("address.city", notNullValue())
		.body("experiences[0].title", notNullValue())			
		.body("experiences[0].company.name", notNullValue())
		.body("experiences[0].company.address.city",notNullValue())
		.body("_links.self.href", containsString("http://localhost/api/profiles/"));
	}
}
