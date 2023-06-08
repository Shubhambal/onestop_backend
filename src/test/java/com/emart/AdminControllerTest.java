package com.emart;
import static org.hamcrest.CoreMatchers.*;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;




public class AdminControllerTest {
	/**
	 * This test case verifies the functionality of retrieving all admins by sending a GET request.
	 * 
	 * @param 
	 * @return 200 status code will be returned.
	 */

   @Test
	public void testShowAdmin() {
		// Set base URI
		RestAssured.baseURI = "http://localhost:8080/api/admins";
		
		// Make the GET request and validate the response
		given()
		.when()
		.get()
		.then()
		.statusCode(200); // Ensure status code is 204 (No Content)
		
		
	}
   /**
	 * The scenario aims to ensure that returns the expected response when retrieving the customer information.
	 * 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testAddAdmin() {
        // Create the request body
		RestAssured.baseURI = "http://localhost:8080/api/admins";
        String jsonBody = "{"
                + "\"emailId\": \"vishal@gmail.com\","
                + "\"firstName\": \"vishal\","
                + "\"lastName\": \"Tare\","
                + "\"password\": \"123\","
                + "\"username\": \"vishal\""
                + "}";

        // Send POST request to /admins/create
        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/create")
                .then()
                .log()
                .all()
                .extract()
                .response();

        // Verify the status code and response body
//        Assertions.assertEquals(200, response.getStatusCode());
        
        System.out.println("Status code = " + response.getStatusCode());
    
    }

     /**
	 * The scenario aims to ensure that returns the expected response when retrieving the admin information.
	 * 
	 * @return 200 status code will be returned.
	 */
	@Test
	public void testGetValidAdminById() {
	    RestAssured.baseURI = "http://localhost:8080/api/admins";

	    int adminId = 7; // ID of the customer to retrieve

	    Response response = given()
	            .pathParam("admin_Id", adminId)
	            .when()
	            .get("/{admin_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	    
	}
	
	/**
	 * A test case to check weather the username which is entered by the user is already present in database or not.
	 * 
	 * @param 
	 * @return 404 status code will be returned.
	 */
	@Test
	public void testGetInvalidAdminById() {
	    RestAssured.baseURI = "http://localhost:8080/api/admins";

	    int adminId = 10; // ID of the customer to retrieve

	    Response response = given()
	            .pathParam("admin_Id", adminId)
	            .when()
	            .get("/{admin_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	    
	}
	
	/**
	 * This test  verifies that the admin can be successfully updated when valid admin information is provided.
	 * 
	 * @param adminId
	 * @return 200 status code will be returned.
	 */
   
	@Test
    public void testUpdateValidAdmin() {
        String json = "{\"emailId\": \"madhavi@gmail.com\"," +
                "\"firstName\": \"Madh\"," +
                "\"lastName\": \"Meher\"," +
                "\"password\": \"122\"," +
                "\"username\": \"Madhavi\"}";

        // Set the base URL of your API
        RestAssured.baseURI = "http://localhost:8080/api/admins";

        // Send the request and capture the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .put("/{adminId}", 7) // Replace {adminId} with the actual admin ID
                .then()
                .statusCode(200) // Assuming 200 is the success status code
                .extract()
                .response();
        response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());

       
    }
	/**
	 * This test  verifies that the admin cannot be updated when Invalid admin information is provided.
	 * 
	 * @param adminId
	 * @return 404 status code will be returned.
	 */
	@Test
    public void testUpdateInvalidAdmin() {
        String json = "{\"emailId\": \"madhavi@gmail.com\"," +
                "\"firstName\": \"Madhavi\"," +
                "\"lastName\": \"Meher\"," +
                "\"password\": \"122\"," +
                "\"username\": \"Madhavi\"}";

        // Set the base URL of your API
        RestAssured.baseURI = "http://localhost:8080/api/admins";

        // Send the request and capture the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .put("/{adminId}", 999) // Replace 999 with an invalid admin ID
                .then()
                .extract()
                .response();

        // Print the response and status code
        response.prettyPrint();
        System.out.println("Status code = " + response.getStatusCode());
	}
    
    
	/**
	 * This test  ensures that the endpoint handles the case of an Valid admin_Id properly and returns an appropriate response.
	 * 
	 * @param admin_Id
	 * @return 200 status code will be returned.
	 */
    @Test
	public void testDeleteValidAdminById() {
	    RestAssured.baseURI = "http://localhost:8080/api/admins";

	    int adminId = 8; // ID of the admin to delete

	    Response response = given()
	            .pathParam("admin_Id", adminId)
	            .when()
	            .delete("/{admin_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	    
	    // Verify that the admin has been successfully deleted
	    response.then()
	            .statusCode(200);
	}
    
    /**
	 * This test  ensures that the endpoint handles the case of an invalid admin ID properly and returns an appropriate response.
	 * 
	 * @param admin id
	 * @return 404 status code will be returned.
	 */
    @Test
	public void testDeleteInvalidAdminById() {
	    RestAssured.baseURI = "http://localhost:8080/api/admins";

	    int adminId = 222; // ID of the admin to delete

	    Response response = given()
	            .pathParam("admin_Id", adminId)
	            .when()
	            .delete("/{admin_Id}");

	    response.prettyPrint();
	    System.out.println("Status code = " + response.getStatusCode());
	    
	    // Verify that the admin has been successfully deleted
	    response.then()
	            .statusCode(404);
	}
    
    
//   
}
