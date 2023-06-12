package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginControllerTest {

	/**
	 * The test scenario aims to ensure that a customer can successfully log in by sending a POST request to the specified endpoint with valid credentials..
	 * 
	 * @return 200 status code will be returned.
	 */
	@Test
	@Order(1)
	public void testValidCustomerLogin() {
	    RestAssured.baseURI = "http://localhost:8080";
	    
	    String json = "{\n"
	            + "    \"username\": \"saurabh8nt\",\n"
	            + "    \"password\": \"Saurabh@123\"\n"
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post("/login/customer")
	            .then()
	            .extract()
	            .response();
	    
	    String statusCode = response.getBody().jsonPath().getString("statusCode");
	    Assertions.assertEquals("OK", statusCode);
	    String statusCodeValue = response.getBody().jsonPath().getString("statusCodeValue");
	    Assertions.assertEquals("200", statusCodeValue);
	    String body =  response.getBody().jsonPath().getString("body");
	    Assertions.assertEquals("Successfully Logged In.", body);
	    
	    response.prettyPrint();
	    
	}

	/**
	 * The test scenario aims to verify that the login API handles incorrect passwords correctly.
	 * 
	 */
	@Test
	@Order(2)
	public void testCustomerLoginWrongPassword() {
	    RestAssured.baseURI = "http://localhost:8080";
	    
	    String json = "{\n"
	            + "    \"username\": \"saurabh8nt\",\n"
	            + "    \"password\": \"Saurabh123\"\n" 					// Wrong Password
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post("/login/customer")
	            .then()
	            .extract()
	            .response();
	    
	    String statusCode = response.getBody().jsonPath().getString("statusCode");
	    Assertions.assertEquals("BAD_REQUEST", statusCode);
	    String statusCodeValue = response.getBody().jsonPath().getString("statusCodeValue");
	    Assertions.assertEquals("400", statusCodeValue);
	    String body =  response.getBody().jsonPath().getString("body");
	    Assertions.assertEquals("Wrong Password. Please try again!", body);
	    
	    response.prettyPrint();
	  
	}
	
	/**
	 * The test scenario aims to verify that the login API handles incorrect username correctly.
	 * 
	 */
	@Test
	@Order(3)
	public void testCustomerLoginWrongUsername() {
	    RestAssured.baseURI = "http://localhost:8080";
	    
	    String json = "{\n"
	            + "    \"username\": \"saurabh\",\n"						// Wrong Username
	            + "    \"password\": \"Saurabh@123\"\n" 					
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post("/login/customer")
	            .then()   
	            .extract()
	            .response();
	    
	    String statusCode = response.getBody().jsonPath().getString("statusCode");
	    Assertions.assertEquals("NOT_FOUND", statusCode);
	    String statusCodeValue = response.getBody().jsonPath().getString("statusCodeValue");
	    Assertions.assertEquals("404", statusCodeValue);
	    String body =  response.getBody().jsonPath().getString("body");
	    Assertions.assertEquals("Customer is not registered yet.", body);
	  
	    response.prettyPrint();
	}
	
	/**
	 * The test scenario aims to ensure that a admin can successfully log in by sending a POST request to the specified endpoint with valid credentials..
	 * 
	 * @return 200 status code will be returned.
	 */
	@Test
	@Order(4)
	public void testValidAdminLogin() {
	    RestAssured.baseURI = "http://localhost:8080/login/admin";
	    
	    String json = "{\n"
	            + "    \"username\": \"adminshubham\",\n"
	            + "    \"password\": \"Admin@123\"\n"
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            .extract()
	            .response();
	    
	    String statusCode = response.getBody().jsonPath().getString("statusCode");
	    Assertions.assertEquals("OK", statusCode);
	    String statusCodeValue = response.getBody().jsonPath().getString("statusCodeValue");
	    Assertions.assertEquals("200", statusCodeValue);
	    String body =  response.getBody().jsonPath().getString("body");
	    Assertions.assertEquals("Successfully Logged In.", body);
	    
	    response.prettyPrint();
	}
	
	/**
	 * The test scenario aims to verify that the login API handles incorrect passwords correctly.
	 * 
	 */
	@Test
	@Order(5)
	public void testAdminLoginWrongPassword() {
	    RestAssured.baseURI = "http://localhost:8080/login/admin";
	    
	    String json = "{\n"
	            + "    \"username\": \"adminshubham\",\n"
	            + "    \"password\": \"1234\"\n"					//Wrong Password
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            .extract()
	            .response();
	    
	    String statusCode = response.getBody().jsonPath().getString("statusCode");
	    Assertions.assertEquals("BAD_REQUEST", statusCode);
	    String statusCodeValue = response.getBody().jsonPath().getString("statusCodeValue");
	    Assertions.assertEquals("400", statusCodeValue);
	    String body =  response.getBody().jsonPath().getString("body");
	    Assertions.assertEquals("Wrong Password. Please try again!", body);
	    
	    response.prettyPrint();
	}
	
	/**
	 * The test scenario aims to verify that the login API handles incorrect usernames correctly.
	 * 
	 */
	@Test
	@Order(6)
	public void testAdminLoginWrongUsername() {
	    RestAssured.baseURI = "http://localhost:8080/login/admin";
	    
	    String json = "{\n"
	            + "    \"username\": \"shubham\",\n"					//Wrong Username
	            + "    \"password\": \"12345\"\n"					
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            .extract()
	            .response();
	    
	    String statusCode = response.getBody().jsonPath().getString("statusCode");
	    Assertions.assertEquals("NOT_FOUND", statusCode);
	    String statusCodeValue = response.getBody().jsonPath().getString("statusCodeValue");
	    Assertions.assertEquals("404", statusCodeValue);
	    String body =  response.getBody().jsonPath().getString("body");
	    Assertions.assertEquals("Admin is not registered yet.", body);
	  
	    response.prettyPrint();
	}
	
}
