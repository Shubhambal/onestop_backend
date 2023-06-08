package com.emart;



import org.junit.jupiter.api.Test;

import com.emart.entities.Cart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;


import static io.restassured.RestAssured.given;

public class CartControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testAddToCart() {
        // Create a Cart object with the necessary data
        Cart cart = new Cart();
        // Set the required properties of the Cart object

        // Send a POST request to add the item to the cart
        Response response = given()
                .contentType(ContentType.JSON)
                .body(cart)
                .when()
                .post("/api/add")
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("Item added to the cart successfully.", response.getBody().asString());
    }

    @Test
    public void testGetAllCart() {
        // Send a GET 'request to retrieve all cart items
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/get")
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetCartById() {
        int cartId = 5; // Provide a valid cart ID
       // cartId=2;
        // Send a GET request to retrieve a specific cart item by ID
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/get/{cart_Id}", cartId)
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testDeleteFromCart() {
        int cartId = 11; // Provide a valid cart ID

        // Send a DELETE request to remove a specific cart item by ID
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/delete/{cart_Id}", cartId)
                .then()
                .extract().response();

        // Check if the ID is not available
        if (response.getStatusCode() == 404) {
            System.out.println("Cart ID " + cartId + " is not available.");
        } else {
            // Assert the response
            Assertions.assertEquals(200, response.getStatusCode());
            Assertions.assertEquals("Item deleted from the cart successfully.", response.getBody().asString());
        }
    }

}

