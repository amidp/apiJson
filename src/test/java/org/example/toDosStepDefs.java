package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.Request;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class toDosStepDefs {
    RequestSpecification request;
    Response response;


    @Given("Base uri is {string}")
    public void baseUriIs(String baseUri) {
        System.out.println("baseUri"+baseUri);
        request=given().baseUri(baseUri);
    }
    @When("use {string} api")
    public void use_api(String basePath) {
        System.out.println("api: "+basePath);
        request.basePath(basePath)
                .when();
    }

    @When("query by {int}")
    public void query_by(Integer id) {
        response = (Response) request.get(String.valueOf(id))
                .then()
                .extract()
                .response();
        System.out.println(response.body().asString());
    }

    @Then("api response should have {int} and {string} and {int}")
    public void api_response_should_have_and_and(int statusCode, String title, int userId) {
        Assert.assertEquals(statusCode,response.statusCode());
        JsonPath responseJson = response.getBody().jsonPath();
        System.out.println(responseJson.toString());
        Assert.assertEquals(title,responseJson.getString("title"));
        Assert.assertEquals(userId,responseJson.getInt("userId"));
    }

    @Then("api response should have {int} and {string} and {string} and {string} and {string}")
    public void api_response_should_have_and_and_and_and(int statusCode, String name, String street, String lat, String catchPhrase ) {
        Assert.assertEquals(statusCode,response.statusCode());
        JsonPath responseJson = response.getBody().jsonPath();
        System.out.println(responseJson.toString());
        Assert.assertEquals(name,responseJson.getString("name"));
        System.out.println(responseJson.getString("name"));
        Assert.assertEquals(street,responseJson.getString("address.street"));
        System.out.println(responseJson.getString("address.street"));
        Assert.assertEquals(lat,responseJson.getString("address.geo.lat"));
        System.out.println(responseJson.getString("address.geo.lat"));
        Assert.assertEquals(catchPhrase,responseJson.getString("company.catchPhrase"));
        System.out.println(responseJson.getString("company.catchPhrase"));

    }
    @Then("api response should have {int} and {int} and {string}")
    public void api_response_should_have_and_and(int statusCode, int userId, String title) {
        System.out.println(response.body().asString());
        Assert.assertEquals(statusCode,response.statusCode());
        System.out.println(response.statusCode());
        JsonPath responseJson = response.getBody().jsonPath();
        Assert.assertEquals(title,responseJson.getString("title"));
        Assert.assertEquals(userId,responseJson.getInt("userId"));
    }





}
