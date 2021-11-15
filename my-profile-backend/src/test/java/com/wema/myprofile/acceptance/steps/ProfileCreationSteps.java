package com.wema.myprofile.acceptance.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wema.myprofile.acceptance.common.ScenarioContextApi;
import com.wema.myprofile.domain.Address;
import com.wema.myprofile.domain.Company;
import com.wema.myprofile.domain.Experience;
import com.wema.myprofile.domain.Profile;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileCreationSteps {

	@Autowired
	private ScenarioContextApi<Profile> context;

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

	@Given("^user wants to create a employee with the following attributes$")
	public void userWantsToCreateAEmployeeWithTheFollowingAttributes(DataTable profileDt) {
		Map<String, String> row = profileDt.asMaps(String.class, String.class).get(0);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Date birthDate;
		try {
			birthDate = formatter.parse(row.get("birthDate"));
		} catch (ParseException e) {
			birthDate = new Date();
		}

		Profile profile = Profile.builder().firstName(row.get("firstName")).lastName(row.get("lastName"))
				.birthDate(birthDate).profileTitle(row.get("profileTitle")).build();
		context.setPostBody(profile);

	}

	@Given("^with the following address of profile$")
	public void userWantsToCreateAEmployeeWithTheFollowingAddressOfProfile(DataTable addressDt) {
		Map<String, String> row = addressDt.asMaps(String.class, String.class).get(0);

		Address address = Address.builder().city(row.get("city")).region(row.get("region")).country(row.get("country"))
				.build();
		((Profile) context.getPostBody(Profile.class)).setAddress(address);
	}

	@Given("^with the following experiences of profile$")
	public void userWantsToCreateAEmployeeWithTheFollowingExperiencesOfProfile(DataTable experienceDt) {
		List<Map<String, String>> rows = experienceDt.asMaps(String.class, String.class);

		List<Experience> experiences = new ArrayList();
		for (Map<String, String> row : rows) {
			Address address = Address.builder().city(row.get("company_city")).region(row.get("company_region"))
					.country(row.get("company_country")).build();
			Company company = Company.builder().name(row.get("company_name")).address(address).build();
			Experience experience = Experience.builder().title(row.get("experience-title"))
					.type(row.get("experience_type")).company(company).build();
			experiences.add(experience);
		}
		((Profile) context.getPostBody(Profile.class)).setExperiences(experiences);
	}

	@When("^I add a new valid profile on ([^\\\"]*)$")
	public void iAddANewValidProfile(String path) {
		context.invokeHttpPost(path, context.getPostBody());
	}

	@Then("^the profile is created$")
	public void shouldReceiveProfileBody() {
		context.response.then().body("firstName", notNullValue()).body("lastName", notNullValue())
				.body("profileTitle", notNullValue()).body("address.city", notNullValue())
				.body("experiences[0].title", notNullValue()).body("experiences[0].company.name", notNullValue())
				.body("experiences[0].company.address.city", notNullValue())
				.body("_links.self.href", containsString("http://localhost/api/profiles/"));
	}
}
