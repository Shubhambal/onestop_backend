package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emart.entities.Payment;

import static io.restassured.RestAssured.given;

public class PaymentControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testShowPayments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/payment")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetPayment() {
        int paymentId = 1; // Update with an existing payment ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/paymentById/" + paymentId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testRemovePayment() {
        int paymentId = 2; // Update with an existing payment ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/payment/" + paymentId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testAddPayment() {
        Payment payment = new Payment();
        // Set the necessary properties of the Payment object

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payment)
                .when()
                .post("/api/payment")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
}
