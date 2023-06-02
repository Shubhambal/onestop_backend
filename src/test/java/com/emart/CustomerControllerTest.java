package com.emart;

import com.emart.entities.Customer;
import com.emart.exception.CustomerNotFoundException;
import com.emart.services.CustomerManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CustomerControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Replace with the actual base URI
    }

    @Test
    public void testShowCustomers() {
        List<Customer> customers = new ArrayList<>();
        // Add some dummy customers to the list

        given()
            .when()
            .get("/api/customers")
        .then()
            .statusCode(200)
            .body("", hasSize(customers.size())); // Assuming the returned list size matches the customers list
    }

    @Test
    public void testGetCustomerById() {
        int customerId = 1; // Replace with an existing customer ID

        given()
            .pathParam("customer_Id", customerId)
        .when()
            .get("/api/customerById/{customer_Id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(customerId));
    }

    @Test
    public void testGetNonExistingCustomerById() {
        int customerId = 100; // Replace with a non-existing customer ID

        given()
            .pathParam("customer_Id", customerId)
        .when()
            .get("/api/customerById/{customer_Id}")
        .then()
            .statusCode(404);
    }

    @Test
    public void testRemoveCustomer() {
        int customerId = 1; // Replace with an existing customer ID

        given()
            .pathParam("customer_Id", customerId)
        .when()
            .delete("/api/customer/{customer_Id}")
        .then()
            .statusCode(200)
            .body(is("Customer deleted successfully."));
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer();
        // Set the properties of the Customer object

        given()
            .contentType(ContentType.JSON)
            .body(customer)
        .when()
            .post("/api/customer")
        .then()
            .statusCode(200)
            .body(is("Customer added successfully."));
    }

    @Test
    public void testGetCustomerByUsername() {
        String username = "john123"; // Replace with an existing username

        given()
            .pathParam("username", username)
        .when()
            .get("/api/getByUserName/{username}")
        .then()
            .statusCode(200)
            .body("username", equalTo(username));
    }

    // Add more test cases for other endpoints and scenarios if needed
}
