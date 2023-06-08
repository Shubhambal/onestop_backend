package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class LoginControllerTest {

    @Test
    public void testValidCustomerLogin() {
        // Set base URI
        RestAssured.baseURI = "http://localhost:8080/login/customer";

        // Request body JSON
        String json = "{\n"
                + "    \"username\": \"saurabh9nt\",\n"
                + "    \"password\": \"Saurabh@123\"\n"
                + "}";

        // Send POST request and validate the response
        Response response = given()
                .contentType(ContentType.JSON) // Set the content type of the request as JSON
                .body(json) // Set the request body with the JSON payload
                .when()   //Specify the HTTP method and other details of the request.
                .post() // Send a POST request to the specified endpoint
                .then() // Perform assertions or extract response
                .extract() // Extract the response
                .response(); // Get the Response object



        // Assert the response
        System.out.println("Status code : " + response.getStatusCode());
        Assertions.assertEquals(200, response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        Assertions.assertEquals("Successfully Logged In.", response.getBody().jsonPath().getString("body"));
    }


    @Test
    public void testCustomerLogin2() {
        // Set base URI
        RestAssured.baseURI = "http://localhost:8080/login/customer";

        // Request body JSON
        String json = "{\n"
                + "    \"username\": \"saurabh8nt\",\n"
                + "    \"password\": \"Saurabh123\"\n"                    // Wrong Password
                + "}";

        // Send POST request and validate the response
        Response response = given()
                .contentType(ContentType.JSON) // Set the content type of the request as JSON
                .body(json) // Set the request body with the JSON payload
                .when()   //Specify the HTTP method and other details of the request.
                .post() // Send a POST request to the specified endpoint
                .then() // Perform assertions or extract response
                .extract() // Extract the response
                .response(); // Get the Response object

        // Assert the response
        System.out.println("Response body: " + response.getBody().asString());
        Assertions.assertEquals("Wrong Password. Please try again!", response.getBody().jsonPath().getString("body"));
    }

    @Test
    public void testCustomerLogin3() {
        // Set base URI
        RestAssured.baseURI = "http://localhost:8080/login/customer";

        // Request body JSON
        String json = "{\n"
                + "    \"username\": \"saurabh\",\n"                        // Wrong Username
                + "    \"password\": \"Saurabh@123\"\n"
                + "}";

        // Send POST request and validate the response
        Response response = given()
                .contentType(ContentType.JSON) // Set the content type of the request as JSON
                .body(json) // Set the request body with the JSON payload
                .when()   //Specify the HTTP method and other details of the request.
                .post() // Send a POST request to the specified endpoint
                .then() // Perform assertions or extract response
                .extract() // Extract the response
                .response(); // Get the Response object
        
        // Assert the response
        System.out.println("Response body: " + response.getBody().asString());
        Assertions.assertEquals("Customer is not registered yet.", response.getBody().jsonPath().getString("body"));
    }

    @Test
    public void testValidAdminLogin1() {
        // Set base URI
        RestAssured.baseURI = "http://localhost:8080/login/admin";

        // Request body JSON
        String json = "{\n"
                + "    \"username\": \"ss3\",\n"
                + "    \"password\": \"123\"\n"
                + "}";

        // Send POST request and validate the response
        Response response = given()
                .contentType(ContentType.JSON) // Set the content type of the request as JSON
                .body(json) // Set the request body with the JSON payload
                .when()   //Specify the HTTP method and other details of the request.
                .post() // Send a POST request to the specified endpoint
                .then() // Perform assertions or extract response
                .extract() // Extract the response
                .response(); // Get the Response object

        // Assert the response
        System.out.println("Status code : " + response.getStatusCode());
        Assertions.assertEquals(200, response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        Assertions.assertEquals("Successfully Logged In.", response.getBody().jsonPath().getString("body"));
    }

    @Test
    public void testValidAdminLogin2() {
        // Set base URI
        RestAssured.baseURI = "http://localhost:8080/login/admin";

        // Request body JSON
        String json = "{\n"
                + "    \"username\": \"ssss\",\n"
                + "    \"password\": \"1234\"\n"                    // Wrong Password
                + "}";

        // Send POST request and validate the response
        Response response = given()
                .contentType(ContentType.JSON) // Set the content type of the request as JSON
                .body(json) // Set the request body with the JSON payload
                .when()   //Specify the HTTP method and other details of the request.
                .post() // Send a POST request to the specified endpoint
                .then() // Perform assertions or extract response
                .extract() // Extract the response
                .response(); // Get the Response object

        // Assert the response
        System.out.println("Response body: " + response.getBody().asString());
        Assertions.assertEquals("Wrong Password. Please try again!", response.getBody().jsonPath().getString("body"));
    }


    @Test
    public void testValidAdminLogin3() {
        // Set base URI
        RestAssured.baseURI = "http://localhost:8080/login/admin";

        // Request body JSON
        String json = "{\n"
                + "    \"username\": \"ssssss\",\n"
                + "    \"password\": \"123\"\n"                    // Wrong Username
                + "}";

        // Send POST request and validate the response
        Response response = given()
                .contentType(ContentType.JSON) // Set the content type of the request as JSON
                .body(json) // Set the request body with the JSON payload
                .when()   //Specify the HTTP method and other details of the request.
                .post() // Send a POST request to the specified endpoint
                .then() // Perform assertions or extract response
                .extract() // Extract the response
                .response(); // Get the Response object

        // Assert the response
        System.out.println("Response body: " + response.getBody().asString());
        Assertions.assertEquals("Admin is not registered yet.", response.getBody().jsonPath().getString("body"));
    }

}
