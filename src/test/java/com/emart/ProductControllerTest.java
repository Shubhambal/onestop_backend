package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.emart.entities.Product;

import static io.restassured.RestAssured.given;

public class ProductControllerTest {

//	@BeforeAll
//	public static void setup() {
//		RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
//	}

	 /**
     * This test case is use to get all product from database.
     *
     * It will return the data with status code 200.
     */
	
	@Test
	public void testShowProducts() {
		Response response = given().contentType(ContentType.JSON).when().get("/api/products").then().extract()
				.response();

		Assertions.assertEquals(200, response.getStatusCode());
		// Add additional assertions to validate the response body or structure
		
		// Assuming you expect the response body to have a "products" array
		JsonPath jsonPath = response.jsonPath();

		Assertions.assertTrue(jsonPath.getList("products") instanceof List, "Expected 'products' to be an array.");
		Assertions.assertTrue(jsonPath.getList("products").size() > 0, "Expected 'products' array to be non-empty.");

	   response.prettyPrint();
	}
	
	
	/**
     * This test case is use to get product of particular id from database.
     *
     * It will return the data with status code 200.
     */
	
	@Test
	public void testGetProduct() {
		int productId = 2; // Update with an existing product ID

		Response response = given().contentType(ContentType.JSON).when().get("/api/productsById/" + productId).then()
				.extract().response();

		Assertions.assertEquals(200, response.getStatusCode());
		// Add additional assertions to validate the response body or structure
		
		 String expectedJson = "{ \"key\": \"value\" }";

	        String responseBody = response.getBody().asString();
	        System.out.println("Actual Response Body: " +responseBody);
	}
	
	/**
     * It is negative testing for get product by id .
     *
     * It will return status port 404.
     */
	
	@Test
	public void testGetProductById_Negative() {
	    RestAssured.baseURI = "http://localhost:8080/api/productsById/";

	    int productId = 999; // Non-existing customer ID

	    Response response = given()
	            .pathParam("p_Id", productId)
	            .when()
	            .get("/{p_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	}
	
	

	/**
     * This test case is use to search product from given keyword from database.
     *
     * It will return the data with status code 200.
     */
	@Test
    public void testSearchProducts() {
        String keyword = "TV"; // Update with a search keyword

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/search/" + keyword)
                .then()
                .extract()
                .response();

        Assertions.assertEquals(200, response.getStatusCode());

        // Assuming the expected JSON response is: { "key": "value" }
        String expectedJson = "{ \"key\": \"value\" }";

        String responseBody = response.getBody().asString();
        System.out.println("Actual Response Body: " +responseBody);

    }


	
	/**
     * This test case is use to remove product from given id from database.
     *
     * It will return the data with status code 200.
     */
	
	@Test
	public void testRemoveProduct() {
	    int productId = 4; // Update with an existing product ID

	    Response response = given().contentType(ContentType.JSON)
	            .when()
	            .delete("/api/products/" + productId)
	            .then()
	            .log() 
	            .all()
	            .extract().response();

	    Assertions.assertEquals(200, response.getStatusCode());
	    Assertions.assertEquals("", response.getBody().asString());
	    // Add additional assertions to validate the response body or structure
	}

	
	/**
     * This test case is use to do negative testing which is to remove the product which does
     * not exist in database.
     *
     * It will return the data with status code 404.
     */
	
	@Test
	public void testRemoveProduct_Negative() {
	    int productId = -1; // Non-existing product ID

	    Response response = given()
	            .contentType(ContentType.JSON)
	            .when()
	            .delete("/api/products/" + productId)
	            .then()
	            .extract()
	            .response();

	    Assertions.assertEquals(404, response.getStatusCode());
	    // Add additional assertions or validations for the response body or structure
	}


	/**
     * This test case is use to add product for given data to database.
     *
     * It will return the data with status code 200 for successfull addition of database .
     */

	@Test
	public void testAddProduct() {
		Product product = new Product(4, "TV", 30000.0f, null, false, false);
		// Set the necessary properties of the Product object

		Response response = given().contentType(ContentType.JSON).body(product).when().post("/api/products").then()
				.extract().response();

		Assertions.assertEquals(200, response.getStatusCode());
		// Add additional assertions to validate the response body or structure
		System.out.println("Product added successfully" );
		
	}



}
