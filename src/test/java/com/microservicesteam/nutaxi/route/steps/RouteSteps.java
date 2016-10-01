package com.microservicesteam.nutaxi.route.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import com.microservicesteam.nutaxi.infrastructure.SpecificationConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RouteSteps {

    private RequestSpecification specification;

    private Response response;

    @Given("^I am a user who wants request a route$")
    public void I_am_a_user() {
        specification = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(SpecificationConfiguration.configuration().getString("route.service.url"))
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @When("^I request a route with an origin and a destination$")
    public void I_request_a_route() {
        response = given().spec(specification)
                .param("origin", "New York")
                .param("destination", "Scranton")
                .when()
                .get("api/route");

    }

    @Then("^I should get the calculated routes$")
    public void I_should_get_the_routes() {
        response.then()
                .statusCode(200)
                .contentType(JSON)
                .body("overviewPolylines", is(not(empty())));
    }

}
