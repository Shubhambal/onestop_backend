package com.emart;


import com.emart.entities.Customer;
import com.emart.exception.CustomerNotFoundException;
import com.emart.services.CustomerManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTest {
	
	/**
	 * The scenario aims to ensure that returns the expected response when retrieving the customer information.
	 * 
	 * @return 200 status code will be returned.
	 */
	@Test
	@Order(2)
	public void testAddCustomerValidUsername() {
	    RestAssured.baseURI = "http://localhost:8080";
 
	    String customerData = "{\r\n"
	            + "    \"username\": \"saurabh8nt\",\r\n"
	            + "    \"password\": \"Saurabh@123\",\r\n"
	            + "    \"first_Name\": \"Saurabh\",\r\n"
	            + "    \"last_Name\": \"Tajane\",\r\n"
	            + "    \"email_Id\": \"saurabh@infobellit.com\",\r\n"
	            + "    \"address\": \"Bangalore\",\r\n"
	            + "    \"wallet\": 0,\r\n"
	            + "    \"primeCustomer\": false\r\n"
	            + "}";
	    
	    
	   Response response = RestAssured.given()
			   .contentType(ContentType.JSON)
	            .body(customerData) 
	            .when()
	            .post("/api/customer")
	            .then()
	            .log()
	            .all()
	            .extract()
	            .response();
	   
	   int statusCode = response.getStatusCode();
       Assertions.assertEquals(200, statusCode);

       String contentType = response.getContentType();
       Assertions.assertEquals("text/plain;charset=UTF-8", contentType);

       // Assert the response body contains expected values
       String responseBody = response.getBody().asString();
       Assertions.assertEquals("Customer added successfully.", responseBody);
	}
	
	/**
	 * A test case to check weather the username which is entered by the user is already present in database or not.
	 * 
	 * @param 
	 * @return 400 status code will be returned.
	 */
	@Test
	@Order(3)
	public void testAddCustomerInvalidUsername() {
	    RestAssured.baseURI = "http://localhost:8080";

	    String json = "{\r\n"
	            + "    \"username\": \"saurabh8nt\",\r\n"
	            + "    \"password\": \"Saurabh@123\",\r\n"
	            + "    \"firstName\": \"Shubham\",\r\n"
	            + "    \"lastName\": \"Tajane\",\r\n"
	            + "    \"email\": \"shubham@gmail.com\",\r\n"
	            + "    \"address\": \"Mumbai\",\r\n"
	            + "    \"wallet\": 0,\r\n"
	            + "    \"primeCustomer\": false\r\n"
	            + "}";

	    Response response = RestAssured.given()
	            .contentType(ContentType.JSON)  							// Set the content type as JSON
	            .body(json)
	            .post("/api/customer")
	            .then()
	            .log()
	            .all()
	            .extract()
	            .response();
	    
	    Assertions.assertEquals("Username is already taken.", response.getBody().asString());
	    Assertions.assertEquals(400, response.getStatusCode());
	    Assertions.assertEquals("text/plain;charset=UTF-8", response.getContentType());
	}
	
	/**
	 * This test case verifies the functionality of retrieving all customers by sending a GET request.
	 * 
	 * @param 
	 * @return 200 status code will be returned.
	 */
	@Test
	@Order(4)
	public void testShowCustomers() {

		// Setting base URI
		RestAssured.baseURI = "http://localhost:8080";

		// Make the GET request and validate the response
		Response response = given()
										.contentType(ContentType.JSON)
										.when()
										.get("/api/customers")
										.then()
										.log()
										.all()
										.extract()
										.response();
		
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("application/json", response.getHeader("Content-Type"));
		
		JsonPath jsonPath = response.jsonPath();
		
		// Assuming there is a customer with the username "saurabh8nt"
		boolean customerExists = jsonPath.getList("username").contains("saurabh8nt");
		Assertions.assertTrue(customerExists);
		
		List<String> customerIds = jsonPath.getList("customer_Id");
		Assertions.assertTrue(customerIds.size() > 0);

	}
	
	
	/**
	 * This test case is specifically designed to test the scenario where there are no customers present.(Empty Customer Table)
	 * 
	 * @return 204 status code will be returned.
	 */
	@Test
	@Order(1)
	public void testShowCustomersEmptyDatabase() {
		// Set base URI
		RestAssured.baseURI = "http://localhost:8080";
		
		// Make the GET request and validate the response
		Response response = given()
										.when()
										.get("/api/customers")
										.then()
										.log()
										.all()
										.extract()
										.response();
		
		Assertions.assertEquals(204, response.getStatusCode());
		
		Assertions.assertTrue(response.getBody().asString().isEmpty());
		
		Assertions.assertEquals(null, response.getHeader("Content-Type"));

	}

	/**
	 * The given test case is focused on retrieving a customer by their ID using the GET request.
	 * 
	 * @param customer_id
	 * @return 200 status code will be returned.
	 */
	
	@Test
	@Order(5)
	public void testGetCustomerByValidId() {
	    RestAssured.baseURI = "http://localhost:8080";

	    int customerId = 1; 						// valid ID of the customer to retrieve

	    Response response = given()
	            .pathParam("customer_Id", customerId)
	            .when()
	            .get("/api/customerById/{customer_Id}")
	    		.then()
	    		.log()
	    		.all()
	    		.extract()
	    		.response();

	    
	    String responseBody = response.getBody().asString();
	    Assertions.assertEquals(true, responseBody.contains("username"));
	    
	    int statusCode = response.getStatusCode();
	    Assertions.assertEquals(200, statusCode);
	    
	    JsonPath jsonPath = response.jsonPath();
	    
        String customerIdValue = jsonPath.getString("customer_Id");
        Assertions.assertEquals("1", customerIdValue);
        
        String customerEmail = jsonPath.getString("email_Id");
        Assertions.assertEquals("saurabh@infobellit.com", customerEmail);
	    
	}
	
	/**
	 * The test case aims to verify the behavior of the API when attempting to retrieve a customer with a non-existing customer ID. 
	 * 
	 * @param customer_id
	 * @return 404 status code will be returned.
	 */
	@Test
	@Order(6)
	public void testGetCustomerByInvalidId() {
	    RestAssured.baseURI = "http://localhost:8080";

	    int customerId = 999; 					// Non-existing customer ID

	    Response response = given()
	            .pathParam("customer_Id", customerId)
	            .when()
	            .get("/api/customerById/{customer_Id}")
	            .then()
	            .log()
	            .all()
	            .extract()
	            .response();
	    
	    // Assertion 1: Verify the response status code is 404 (Not Found)
	    int statusCode = response.getStatusCode();
        Assertions.assertEquals(404, statusCode);

	}
	
	/**
	 * This test  verifies that the customer's wallet can be successfully updated when valid customer information is provided.
	 * 
	 * @param customer_id
	 * @return 200 status code will be returned.
	 */
	 @Test
	 @Order(7)
	    public void testUpdateValidCustomerWallet() {
		 RestAssured.baseURI = "http://localhost:8080/";
	        int validCustomerId = 1;
	        Customer updatedCustomer = new Customer(); 
	        updatedCustomer.setwallet(100000);
	        Response response = given()
	            .pathParam("customer_Id", validCustomerId)
	            .contentType(ContentType.JSON)
	            .body(updatedCustomer)
	            .when()
	            .put("api/customer/{customer_Id}");
	        
	        int statusCode = response.getStatusCode();
	        Assertions.assertEquals(200, statusCode);
	        
	        String contentType = response.contentType();
	        Assertions.assertEquals("text/plain;charset=UTF-8",contentType);
	        
	        String responseBody = response.getBody().asString();
	        Assertions.assertEquals("Customer updated successfully.", responseBody);

	        
	    }
	
	 /**
		 * This test  verifies that the customer's wallet cannot be updated when Invalid customer information is provided.
		 * 
		 * @param customer_id
		 * @return 404 status code will be returned.
		 */
	 @Test
	 @Order(8)
	    public void testUpdateInvalidCustomerWallet() {
	        int invalidCustomerId = 999;
	        Customer updatedCustomer = new Customer(); 		// Provide the updated customer data

	       Response response =  given()
	            .pathParam("customer_Id", invalidCustomerId)
	            .contentType(ContentType.JSON)
	            .body(updatedCustomer)
	            .when()
	            .put("api/customer/{customer_Id}");

	       
	        int statusCode = response.getStatusCode();
	        Assertions.assertEquals(404, statusCode);
	        
	        String contentType = response.contentType();
	        Assertions.assertEquals("text/plain;charset=UTF-8",contentType);
	        
	        String responseBody = response.getBody().asString();
	        Assertions.assertEquals("Customer not found with ID: " + invalidCustomerId , responseBody);
	       
	    }
	 
	 /**
		 * This test  ensures that the endpoint handles the case of an Valid customer ID properly and returns an appropriate response.
		 * 
		 * @param customer_id
		 * @return 200 status code will be returned.
		 */
	 @Test
	 @Order(10)
	 @Disabled
	 public void testRemoveValidCustomer() {

			RestAssured.baseURI = "http://localhost:8080/";
	        int validCustomerId = 1;
	        
	        Response response = given()
	            .pathParam("customer_Id", validCustomerId)
	            .when()
	            .delete("api/customer/{customer_Id}")
	            .then()
	            .log()
	            .all()
	            .extract()
	            .response();
	        
	        int statusCode = response.getStatusCode();
	        Assertions.assertEquals(200, statusCode);
	        
	        String contentType = response.contentType();
	        Assertions.assertEquals("text/plain;charset=UTF-8",contentType);
	        
	        String responseBody = response.getBody().asString();
	        Assertions.assertEquals("Customer deleted successfully.", responseBody);
	 
	    }
	
	 /**
		 * This test  ensures that the endpoint handles the case of an invalid customer ID properly and returns an appropriate response.
		 * 
		 * @param customer_id
		 * @return 404 status code will be returned.
		 */
	@Test
	@Order(9)
    public void testRemoveInvalidCustomer() {
        int invalidCustomerId = 999;
        
        Response response = given()
            .pathParam("customer_Id", invalidCustomerId)
            .when()
            .delete("api/customer/{customer_Id}")
            .then()
            .log()
            .all()
        	.extract()
        	.response();
        
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(404, statusCode);
        
        String contentType = response.contentType();
        Assertions.assertEquals("text/plain;charset=UTF-8",contentType);
        
        String responseBody = response.getBody().asString();
        Assertions.assertEquals("Customer not found with ID: " + invalidCustomerId, responseBody);
        
        System.out.println("Status code : " + response.getStatusCode());
  
    }
	
}
