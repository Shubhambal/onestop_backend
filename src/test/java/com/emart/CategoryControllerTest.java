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
    
    /**
	 * The test scenario aims to retrieve the categories successfully  by sending a GET request to the specified endpoint with valid category Id.
	 * 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testGetCategory1() {
        int categoryId = 4; 											// Update with an existing category ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/categoriesById/" + categoryId)
                .then()
                .extract().response();
        
        
        System.out.println(response.asPrettyString());
        Assertions.assertEquals(200, response.getStatusCode());

    }
    
    /**
	 * The test scenario aims to handles the method when  Invalid category Id is sent.
	 * 
	 * @return 404 status code will be returned.
	 */
    @Test
    public void testGetCategory2() {
        int categoryId = 999; 								// Update with an non existing category ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/categoriesById/" + categoryId)
                .then()
                .extract().response();
        
        
        System.out.println(response.asPrettyString());
        Assertions.assertEquals(404, response.getStatusCode());
       
    }
    
    /**
	 * This test ensures to retrive all the categories when sent an GET request at specific endpoint.
	 * 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testGetCategories() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/categories")
                .then()
                .extract().response();
        
        System.out.println(response.asPrettyString());
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
    
    /**
	 * The test scenario aims to delete the categories successfully  by sending a DELETE request to the specified endpoint with valid category Id.
	 * 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testRemoveCategory() {
        int category_Id = 5; // Update with an existing category ID

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
