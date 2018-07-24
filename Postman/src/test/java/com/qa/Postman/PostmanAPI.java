package com.qa.Postman;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class PostmanAPI {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	@Given("^a film exists with he title Lord_of_the_Rings$")
	public void a_film_exists_with_the_Title_Lord_of_the_Rings() {
		request = request.given().contentType(ContentType.JSON);
	}
	
	@When("^a user retrieves the film by title$")
	public void a_user_retrives_the_film_by_title() {
		response = request.when().get("https://www.omdbapi.com/?apikey=eec4a937&t=Lord of the Rings");
		}
	@Then("^the status code reads 200$")
	public void the_status_code_reads(int statusCode) {
		json = response.then().statusCode(200);
	}
	
	@Given("^a film exists with the Title Lord of the Rings$")
	public void a_film_exists_with_the_title_Lord_of_the_Rings() {
		request = request.given().contentType(ContentType.JSON);
	}
	@When("^a user retrieves the film by the title Lord of the Rings$")
	public void a_user_retreives_the_film_by_the_title_Lord_of_the_Rings() {
		response = request.when().get("https://www.omdbapi.com/?apikey=eec4a937&t=Lord of the Rings");
	}
	@And("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() {
		expect().body("Rated", equalTo("R"));
	}
	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) {
		request = given().contentType(ContentType.JSON);
	}
	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) {
		response = request.when().get("https://www.omdbapi.com/?apikey=eec4a937&t=Lord of the Rings");
	}
	@And("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) {
		expect().body("Rated", equalTo("PG"));
	}
	@Given("^a film exists with the Title_<title>$")
	public void a_film_exists_with_the_Title_(String arg1) {
		request = given().contentType(ContentType.JSON);
	}
	@When("^a user retrieves the film by the title_<title>$")
	public void a_user_retrieves_the_film_by_the_title_(String arg1) {
		response = request.when().get("https://www.omdbapi.com/?apikey=eec4a937&t=Lord of the Rings");
	}
	@And("^the Rated Field is equal to_<title>$")
	public void the_Rated_Field_is_equal_to_(String arg1) {
		expect().body("Rated", equalTo("<rating>"));
	
}
