package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emart.entities.ProductDetails;

import static io.restassured.RestAssured.given;

public class ProductDetailsControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testShowProductDetails() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productdetails")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetProductDetail() {
        int productDetailId = 1; // Update with an existing product detail ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productDetailsById/" + productDetailId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetDetails() {
        int productId = 2; // Update with an existing product ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productdetails/" + productId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testDelete() {
        int productDetailId = 1; // Update with an existing product detail ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/productdetails/" + productDetailId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testAddProductDetails() {
        ProductDetails productDetails = new ProductDetails();
        // Set the necessary properties of the ProductDetails object

        Response response = given()
                .contentType(ContentType.JSON)
                .body(productDetails)
                .when()
                .post("/api/productdetails")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
}
