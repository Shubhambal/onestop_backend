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
    
    /**
	 * This test case verifies the functionality of retrieving all productDetails by sending a GET request.
	 * 
	 * @param 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testShowProductDetails() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productdetails")
                .then()
                .extract().response();
        
        System.out.println(response.asPrettyString());
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
    
    /**
	 * The given test case is focused on retrieving a product detail by their ID using the GET request.
	 * 
	 * @param productDetailId
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testGetProductDetail() {
        int productDetailId = 1; // Update with an existing product detail ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productDetailsById/" + productDetailId)
                .then()
                .extract().response();
        
        System.out.println(response.asPrettyString());
        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
    
    
    @Test
    public void testGetDetails() {
        int productId = 1; 								// Update with an existing product ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/productdetails/" + productId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
       
    }
    /**
	 * This test  ensures that the endpoint handles the case of an valid productDetail Id properly and returns an appropriate response.
	 * 
	 * @param customer_id
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testDelete() {
        int productDetailId = 2; // Update with an existing product detail ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/productdetails/" + productDetailId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }
    
    /**
	 * The scenario aims to add a productDetail
	 * 
	 * @param productDetails 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testAddProductDetails() {
    	// ProductDetails productDetails = new ProductDetails();
        // Set the necessary properties of the ProductDetails object
    	
    	String json = "{\r\n"
    			+ "    \"p_Description\": \"LG Mobile\",\r\n"
    			+ "    \"product\": {\r\n"
    			+ "        \"p_Name\": \"product1\",\r\n"
    			+ "        \"p_Price\": 100.0,\r\n"
    			+ "        \"p_Image\": \"image.jpg\",\r\n"
    			+ "        \"p_Prime\": false,\r\n"
    			+ "        \"p_Promotion\": false\r\n"
    			+ "    }\r\n"
    			+ "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/api/productdetails")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
    }
}
