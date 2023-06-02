package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emart.entities.Admin;
import com.emart.entities.Customer;

import static io.restassured.RestAssured.given;

public class LoginControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testAuthenticateAdmin() {
        // Create an Admin object with the necessary login credentials
        Admin admin = new Admin();
        // Set the required properties of the Admin object

        // Send a POST request to authenticate the admin
        Response response = given()
                .contentType(ContentType.JSON)
                .body(admin)
                .when()
                .post("/login/admin")
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testAuthenticateCustomer() {
        // Create a Customer object with the necessary login credentials
        Customer customer = new Customer();
        // Set the required properties of the Customer object

        // Send a POST request to authenticate the customer
        Response response = given()
                .contentType(ContentType.JSON)
                .body(customer)
                .when()
                .post("/login/customer")
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
}

