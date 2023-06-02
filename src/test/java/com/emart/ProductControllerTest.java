package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emart.entities.Product;

import static io.restassured.RestAssured.given;

public class ProductControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testShowProducts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/products")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetProduct() {
        int productId = 4; // Update with an existing product ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productsById/" + productId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testRemoveProduct() {
        int productId = 2; // Update with an existing product ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/products/" + productId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(4,"TV",30000.0f,null,false,false);
        // Set the necessary properties of the Product object

        Response response = given()
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .post("/api/products")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

//    @Test
//    public void testGetProductsByCategory() {
//        int categoryId = 1; // Update with an existing category ID
//
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/productsByCat/" + categoryId)
//                .then()
//                .extract().response();
//
//        Assertions.assertEquals(200, response.getStatusCode());
//        // Add additional assertions to validate the response body or structure
//    }

    @Test
    public void testSearchProducts() {
        String keyword = "TV"; // Update with a search keyword

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/search/" + keyword)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

//    @Test
//    public void testGetProductsByPromotion() {
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/promotion")
//                .then()
//                .extract().response();
//
//        Assertions.assertEquals(200, response.getStatusCode());
//        // Add additional assertions to validate the response body or structure
//    }
}
