package com.emart;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import com.emart.entities.Customer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class CustomerControllerTest {

	@Test
	public void testShowCustomers1() {
		// Set base URI
		RestAssured.baseURI = "http://localhost:8080/api/customers";
		
		// Make the GET request and validate the response
		given()
		.when()
		.get()
		.then()
		.statusCode(204); // Ensure status code is 204 (No Content)
	}
	
	@Test
	public void testAddCustomer1() {
	    RestAssured.baseURI = "http://localhost:8080/api/customer";

	    String json = "{\r\n"
	            + "    \"username\": \"saurabh7nt\",\r\n"
	            + "    \"password\": \"Saurabh@123\",\r\n"
	            + "    \"first_Name\": \"Saurabh\",\r\n"
	            + "    \"last_Name\": \"Tajane\",\r\n"
	            + "    \"email_Id\": \"saurabh@gmail.com\",\r\n"
	            + "    \"address\": \"Bangalore\",\r\n"
	            + "    \"wallet\": 0,\r\n"
	            + "    \"primeCustomer\": false\r\n"
	            + "}";

	    RestAssured.given()
	            .contentType("application/json")
	            .body(json)
	            .post()
	            .then()
	            .log()
	            .all()
	            .statusCode(200)
	            .body(equalTo("Customer added successfully."));
	}
	
	/**
	 * A test case to check weather the username which is entered by the user is already present in database or not.
	 * 
	 * @param 
	 * @return 400 status code will be returned.
	 */
	@Test
	public void testAddCustomer2() {
	    RestAssured.baseURI = "http://localhost:8080/api/customer";

	    String json = "{\r\n"
	            + "    \"username\": \"saurabh7nt\",\r\n"
	            + "    \"password\": \"Saurabh@123\",\r\n"
	            + "    \"firstName\": \"Shubham\",\r\n"
	            + "    \"lastName\": \"Tajane\",\r\n"
	            + "    \"email\": \"shubham@gmail.com\",\r\n"
	            + "    \"address\": \"Mumbai\",\r\n"
	            + "    \"wallet\": 0,\r\n"
	            + "    \"primeCustomer\": false\r\n"
	            + "}";

	    RestAssured.given()
	            .contentType("application/json")  // Set the content type as JSON
	            .body(json)
	            .post()
	            .then()
	            .log()
	            .all()
	            .statusCode(400)
	            .body(equalTo("Username is already taken."));
	}
	
	/**
	 * This test case verifies the functionality of retrieving all customers by sending a GET request.
	 * 
	 * @param 
	 * @return 200 status code will be returned.
	 */
	@Test
	public void testShowCustomers2() {

		// Setting base URI
		RestAssured.baseURI = "http://localhost:8080/api/customers";

		// Make the GET request and validate the response
		Response response = given()
										.contentType(ContentType.JSON)
										.when()
										.get();
		response.prettyPrint();
		System.out.println("Status code = "+response.getStatusCode());
		
	}

	/**
	 * The given test case is focused on retrieving a customer by their ID using the GET request.
	 * 
	 * @param customer_id
	 * @return 200 status code will be returned.
	 */
	@Test
	public void testGetCustomerById1() {
	    RestAssured.baseURI = "http://localhost:8080/api/customerById";

	    int customerId = 2; // ID of the customer to retrieve

	    Response response = given()
	            .pathParam("customer_Id", customerId)
	            .when()
	            .get("/{customer_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	    
	}
	
	/**
	 * The test case aims to verify the behavior of the API when attempting to retrieve a customer with a non-existing customer ID. 
	 * 
	 * @param customer_id
	 * @return 404 status code will be returned.
	 */
	@Test
	public void testGetCustomerById2() {
	    RestAssured.baseURI = "http://localhost:8080/api/customerById";

	    int customerId = 999; // Non-existing customer ID

	    Response response = given()
	            .pathParam("customer_Id", customerId)
	            .when()
	            .get("/{customer_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	}

	 @Test
	    public void testUpdateCustomerWallet1() {
		 RestAssured.baseURI = "http://localhost:8080/api/customer/{customer_Id}";
	        int validCustomerId = 3;
	        Customer updatedCustomer = new Customer(); // Provide the updated customer data
	        updatedCustomer.setwallet(1000);
	        Response response = given()
	            .pathParam("customer_Id", validCustomerId)
	            .contentType(ContentType.JSON)
	            .body(updatedCustomer)
	            .when()
	            .put()
	            .then()
	            .statusCode(200)
	            .contentType(ContentType.TEXT)
	            .body(equalTo("Customer updated successfully."))
	            .extract()
	            .response();
	        
	        System.out.println("Status code = " + response.getStatusCode()); System.out.println();
	    }
	
	 @Test
	    public void testUpdateCustomerWallet2() {
	        int invalidCustomerId = 999;
	        Customer updatedCustomer = new Customer(); // Provide the updated customer data

	       Response response =  given()
	            .pathParam("customer_Id", invalidCustomerId)
	            .contentType(ContentType.JSON)
	            .body(updatedCustomer)
	            .when()
	            .put("api/customer/{customer_Id}")
	            .then()
	            .statusCode(404)
	            .contentType(ContentType.TEXT)
	            .body(equalTo("Customer not found with ID: " + invalidCustomerId))
	            .extract()
	            .response();
	       System.out.println(response.getBody().asString());
	       System.out.println("Status code : " + response.getStatusCode());
	    }
	 
	
	@Test
    public void testRemoveCustomer1() {

		RestAssured.baseURI = "http://localhost:8080/";
        int validCustomerId = 3;
        
        Response response = given()
            .pathParam("customer_Id", validCustomerId)
            .when()
            .delete("api/customer/{customer_Id}")
            .then()
            .statusCode(200)
            .contentType(ContentType.TEXT)
            .body(equalTo("Customer deleted successfully."))
            .extract()
            .response();
        
        System.out.println("Status Code : " + response.statusCode());
 
    }
	
	
	@Test
    public void testRemoveCustomer2() {
        int invalidCustomerId = 999;
        
        Response response = given()
            .pathParam("customer_Id", invalidCustomerId)
            .when()
            .delete("api/customer/{customer_Id}")
            .then()
            .statusCode(404)
            .contentType(ContentType.TEXT)
            .body(equalTo("Customer not found with ID: " + invalidCustomerId))
        	.extract()
        	.response();
        
        System.out.println("Status code : " + response.getStatusCode());
  
    }
	
}
