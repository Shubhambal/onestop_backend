package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emart.entities.Category;

import static io.restassured.RestAssured.given;

public class CategoryControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testGetCategory() {
        int categoryId = 1; // Update with an existing category ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/categoriesById/" + categoryId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testGetCategories() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/categories")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

//    @Test
//    public void testGetSubCategories() {
//        int parentId = 1; // Update with an existing parent category ID
//
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/subcategories/" + parentId)
//                .then()
//                .extract().response();
//
//        Assertions.assertEquals(200, response.getStatusCode());
//        // Add additional assertions to validate the response body or structure
//    }

    @Test
    public void testRemoveCategory() {
        int category_Id = 9; // Update with an existing category ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/categories/" + category_Id)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
        Assertions.assertEquals("Category removed successfully.", response.getBody().asString());
    }

    @Test
    public void testAddCategory() {
        Category category = new Category();
        // Set the necessary properties of the Category object

        Response response = given()
                .contentType(ContentType.JSON)
                .body(category)
                .when()
                .post("/api/categories")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
}
