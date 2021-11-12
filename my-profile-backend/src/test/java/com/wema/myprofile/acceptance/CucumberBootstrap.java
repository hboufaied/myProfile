package com.wema.myprofile.acceptance;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.wema.myprofile.acceptance.common.ScenarioContextApi;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.config.LogConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@CucumberContextConfiguration
public class CucumberBootstrap {

	@Autowired
	private ScenarioContextApi apiContext;

	@Autowired
	private MockMvc mvc;

	@Before
	public void setupForApi() {
		RestAssuredMockMvc.mockMvc(mvc);
		RestAssuredMockMvc.config = RestAssuredMockMvc.config()
				.logConfig(new LogConfig(apiContext.getReport().getRestLogPrintStream(), true));
	}

	@After
	public void tearDownForApi(Scenario scenario) throws IOException {
		apiContext.getReport().write(scenario);
	}
}
