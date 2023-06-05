package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class LoginControllerTest {


	@Test
	public void testValidCustomerLogin() {
	    RestAssured.baseURI = "http://localhost:8080/login/customer";
	    
	    String json = "{\n"
	            + "    \"username\": \"saurabh9nt\",\n"
	            + "    \"password\": \"Saurabh@123\"\n"
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            .extract()
	            .response();
	    
	    System.out.println("Status code : " + response.getStatusCode());
	    Assertions.assertEquals(200, response.getStatusCode());
	    Assertions.assertEquals("Successfully Logged In.", response.getBody().jsonPath().getString("body"));
	}


	@Test
	public void testCustomerLogin2() {
	    RestAssured.baseURI = "http://localhost:8080/login/customer";
	    
	    String json = "{\n"
	            + "    \"username\": \"saurabh9nt\",\n"
	            + "    \"password\": \"Saurabh123\"\n" 					// Wrong Password
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            
	            .extract()
	            .response();
	    
	    System.out.println("Response body: " + response.getBody().asString());
	    Assertions.assertEquals("Wrong Password. Please try again!", response.getBody().jsonPath().getString("body"));
	  
	}
	
	@Test
	public void testCustomerLogin3() {
	    RestAssured.baseURI = "http://localhost:8080/login/customer";
	    
	    String json = "{\n"
	            + "    \"username\": \"saurabh\",\n"						// Wrong Username
	            + "    \"password\": \"Saurabh@123\"\n" 					
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()      
	            .extract()
	            .response();
	    
	    System.out.println("Response body: " + response.getBody().asString());
	    Assertions.assertEquals("Customer is not registered yet.", response.getBody().jsonPath().getString("body"));
	  
	}

	@Test
	public void testValidAdminLogin1() {
	    RestAssured.baseURI = "http://localhost:8080/login/admin";
	    
	    String json = "{\n"
	            + "    \"username\": \"ss\",\n"
	            + "    \"password\": \"123\"\n"
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            .extract()
	            .response();
	    
	    System.out.println("Status code : " + response.getStatusCode());
	    Assertions.assertEquals(200, response.getStatusCode());
	    Assertions.assertEquals("Successfully Logged In.", response.getBody().jsonPath().getString("body"));
	}
	
	@Test
	public void testValidAdminLogin2() {
	    RestAssured.baseURI = "http://localhost:8080/login/admin";
	    
	    String json = "{\n"
	            + "    \"username\": \"ss\",\n"
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
	    
	    System.out.println("Response body: " + response.getBody().asString());
	    Assertions.assertEquals("Wrong Password. Please try again!", response.getBody().jsonPath().getString("body"));
	}
	
	
	@Test
	public void testValidAdminLogin3() {
	    RestAssured.baseURI = "http://localhost:8080/login/admin";
	    
	    String json = "{\n"
	            + "    \"username\": \"sssss\",\n"
	            + "    \"password\": \"123\"\n"					//Wrong Password
	            + "}";
	    
	    Response response = given()
	            .contentType(ContentType.JSON)
	            .body(json)
	            .when()
	            .post()
	            .then()
	            .extract()
	            .response();
	    
	    System.out.println("Response body: " + response.getBody().asString());
	    Assertions.assertEquals("Admin is not registered yet.", response.getBody().jsonPath().getString("body"));
	}
	
}

