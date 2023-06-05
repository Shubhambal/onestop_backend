package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.emart.entities.Orders;
import static io.restassured.RestAssured.given;

public class OrdersControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testAddOrder() {
        // Create an Orders object with the necessary data
        Orders order = new Orders();
        // Set the required properties of the Orders object

        // Send a POST request to add the order
        Response response = given()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post("/api/addorders")
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testGetAllOrders() {
        // Send a GET request to retrieve all orders
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/orders")
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetOrderById() {
        int orderId = 4; // Provide a valid order ID
        
        // Send a GET request to retrieve a specific order by ID
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/orders/{order_Id}", orderId)
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testDeleteOrder() {
        int orderId = 5; // Provide a valid order ID
//        orderId =2;
        // Send a DELETE request to remove a specific order by ID
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("api/orders/delete/{order_Id}", orderId)
                .then()
                .extract().response();

        // Assert the response
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
