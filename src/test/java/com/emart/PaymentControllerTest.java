package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emart.entities.Orders;
import com.emart.entities.Payment;

import static io.restassured.RestAssured.given;

public class PaymentControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/payment"; // Update the base URL to match your application's URL
    }

   
    @Test
    public void testAddPayment() {
    	
    	String json = "{\r\n"
    			+ "  \"payment_Id\": 1,\r\n"
    			+ "  \"payment_Type\": \"Credit Card\",\r\n"
    			+ "  \"amount\": 100.0,\r\n"
    			+ "  \"orders\": {\r\n"
    			+ "    \"order_Id\": 1\r\n"
    			+ "  }\r\n"
    			+ "}\r\n"
    			+ "";
       
        Response response = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post()
                .then()
                .extract().response();

     
        response.prettyPrint();
        System.out.println("Status code = " + response.getStatusCode());
     
    }
    
    
    /**
	 * This test case verifies the functionality of retrieving all payment by sending a GET request.
	 * 
	 * @param 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testShowAllPayments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();

        // Assert that the endpoint is accessible
        Assertions.assertEquals(200, response.getStatusCode());

      
        // Assert that the response contains the expected fields
        Assertions.assertTrue(response.getBody().jsonPath().get("payments") != null);
        response.prettyPrint();
        System.out.println("Status code = " + response.getStatusCode());

        
    }

    

    /**
	 * The scenario aims to ensure that returns the expected response when retrieving the payment information.
	 * 
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testGetValidPaymentById() {
        int paymentId = 1; // Update with an existing payment ID

        Response response = given()
        		 .pathParam("payment_Id", paymentId)
 	            .when()
 	            .get("/{payment_Id}");

        Assertions.assertEquals(200, response.getStatusCode());
        System.out.println(response.asPrettyString());
        System.out.println("Status code = " + response.getStatusCode());
       


       
    }
    
 
    /**
	 * A test case to check weather the paymentid which is entered by the user is already present in database or not.
	 * 
	 * @param 
	 * @return 404 status code will be returned.
	 */
    @Test
    public void testGetPaymentByInvalidId() {
        int paymentId = 9999; // Replace with an invalid payment ID

        Response response = given()
                .pathParam("payment_Id", paymentId)
                .when()
                .get("/{payment_Id}");

        Assertions.assertEquals(404, response.getStatusCode());
        System.out.println(response.asPrettyString());
        System.out.println("Status code = " + response.getStatusCode());

       
    }


   
    /**
	 * This test  ensures that the endpoint handles the case of an Valid payment_Id properly and returns an appropriate response.
	 * 
	 * @param payment_Id
	 * @return 200 status code will be returned.
	 */
    @Test
    public void testRemovevalidPaymentId() {
        int paymentId = 2; // Replace with an existing payment ID

        RestAssured.baseURI = "http://localhost:8080/api/payment";

        Response response = given()
                .pathParam("payment_Id", paymentId)
                .when()
                .delete("/{payment_Id}");

        Assertions.assertEquals(200, response.getStatusCode());
        System.out.println("Status code = " + response.getStatusCode());
    }

    

    
	
    /**
	 * This test  ensures that the endpoint handles the case of an invalid paymentId properly and returns an appropriate response.
	 * 
	 * @param paymentId
	 * @return 404 status code will be returned.
	 */
    @Test
    public void testRemovePaymentWithInvalidId() {
        int paymentId = -1; // Update with an invalid payment ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(""+paymentId)
                .then()
                .extract().response();

        Assertions.assertEquals(404, response.getStatusCode());
    }

    

    
}
