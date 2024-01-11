package com.rest.stepdef;

import com.rest.restClasses.TestDataBuild;
import com.rest.restClasses.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static com.rest.restClasses.Utils.getJsonPath;
import static com.rest.restClasses.Utils.requestSpecificationBuild;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static org.testng.AssertJUnit.assertEquals;

public class FristStepDef {

        static RequestSpecification requestSpecification;

        static ResponseSpecification responseSpecification;
        static Response response;
        TestDataBuild testDataBuild =new TestDataBuild();

        static String user_id;
        static String token = "526ce8f2c9d384c01e014af15b21576aab46d1d1e02a2fcb6052431e98660456";



        @Given("Add User Payload with {string}  {string} {string}")
        public void add_user_payload_with(String name, String email, String gender) throws IOException {
                requestSpecification = given().spec(requestSpecificationBuild()).body(testDataBuild.createUserData(name, email, gender));
        }


        @When("user calls {string} with {string} http request")
        public void user_calls_with_http_request(String resource, String method) {
                // Write code here that turns the phrase above into concrete actions
                APIResources resourceAPI=APIResources.valueOf(resource);
                responseSpecification =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

                if(method.equalsIgnoreCase("POST")){
                        response =requestSpecification.when().post(resourceAPI.getResource());

                }
                else if(method.equalsIgnoreCase("GET")){
                        String getUrl = resourceAPI.getResource() + user_id;
                        response =requestSpecification.when().get(getUrl);

                } else if(method.equalsIgnoreCase("DELETE")) {
                        String getUrl = resourceAPI.getResource() + user_id;
                        response =requestSpecification.when().delete(getUrl);
                }
        }

        @Then("the API call got success with status code {int}")
        public void the_api_call_got_success_with_status_code(Integer statusCode) {
                // Write code here that turns the phrase above into concrete actions

                assertThat(response.statusCode(),is(equalTo(statusCode)));
        }

        @Then("{string} in response body is {string}")
        public void in_response_body_is(String keyValue, String expectedVal) {
               assertThat(getJsonPath(response,keyValue),is(equalTo(expectedVal)));
        }

        @Then("verify user_Id created maps to {string} using {string}")
        public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {

                // requestSpec
                user_id=getJsonPath(response,"id");
                requestSpecification=given().spec(requestSpecificationBuild());
                user_calls_with_http_request(resource,"GET");
                String actualName=getJsonPath(response,"name");
                assertEquals(actualName,expectedName);


        }
}
