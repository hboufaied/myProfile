package com.wema.myprofile.acceptance.common;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class ScenarioContextApi<T> {

	@LocalServerPort
	int port;

	private ScenarioReport report;
	public MockMvcRequestSpecification request;
	public MockMvcResponse response;
	public T postBody;
	public Map<String, Object> queryParams = new HashMap<>();

	public ScenarioContextApi() {
		reset();
	}

	private void reset() {
		report = new ScenarioReport();
		request = null;
		response = null;
		postBody = null;
		queryParams.clear();
	}

	public void invokeHttpGet(String path, Object... pathParams) {
		request = given().log().all();
		response = request.when().get(path, pathParams);
		response.then().log().all();
	}

	public void invokeHttpPost(String path, Object data) {
		request = given().log().all().body(data).queryParams(queryParams).contentType(ContentType.JSON);
		response = request.post(path);
		response.then().log().all();
	}

	public ScenarioReport getReport() {
		return report;
	}

	public Object getPostBody() {
		return postBody;
	}

	public void setPostBody(T postBody) {
		this.postBody = postBody;
	}

	public T getPostBody(Class<T> clazz) {
		return clazz.cast(getPostBody());
	}
}