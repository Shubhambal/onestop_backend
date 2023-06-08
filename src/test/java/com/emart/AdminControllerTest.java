package com.emart;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.emart.entities.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

public class AdminControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testGetAdminById() {
        int adminId = 10; // Update with an existing admin ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/admins/" + adminId);

        // Print the status code and response body on the console
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + responseBody);

        Assertions.assertEquals(200, statusCode);
//        Assertions.assertEquals("Admin Retrived successfully", responseBody);
    }


    @Test
    public void testCreateAdmin() {
        Admin admin = new Admin();
        admin.setUsername("ss3");
        admin.setPassword("123");
        admin.setFirstName("shubham");
        admin.setLastName("Bal");
        admin.setEmailId("shubham@gmail.com");

        // Serialize the Admin object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String adminJson;
        try {
            adminJson = objectMapper.writeValueAsString(admin);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return; // Return or handle the exception appropriately
        }

        // Send the request with the JSON payload
        Response response = given()
                .contentType(ContentType.JSON)
                .body(adminJson)
                .when()
                .post("/admins/create")
                .then()
                .extract().response();

        System.out.println("Status code : " + response.getStatusCode());
        Assertions.assertEquals(200, response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
       //Assertions.assertEquals("Admin created successfully", response.getBody().asString());
        // Add additional assertions to validate the response body or structure
    }


 @Test
 public void testUpdateAdmin() {
     int adminId = 35; // Update with an existing admin ID
     Admin admin = new Admin();
     // Set the updated properties of the Admin object
     admin.setUsername("abcd2");
     admin.setPassword("1234");
     admin.setFirstName("shubham1");
     admin.setLastName("Bal");
     admin.setEmailId("shubham@gmail.com");

     Response response = given()
             .contentType(ContentType.JSON)
             .body(admin)
             .when()
             .put("/admins/" + adminId);

     // Print the response body on the console
//     response.then().log().body();
     System.out.println("Status code : " + response.getStatusCode());
     Assertions.assertEquals(200, response.getStatusCode());
     System.out.println("Response body: " + response.getBody().asString());
//  Assertions.assertEquals("Admin updated successfully", response.getBody().asString());
     // Add additional assertions to validate the response body or structure
 }


    @Test
    public void testDeleteAdmin() {
        int adminId = 26; // Update with an existing admin ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/admins/" + adminId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        // Add additional assertions to validate the response body or structure
    }

//    @Test
//    public void testAdminLogin() {
//        Admin admin = new Admin();
//        // Set the email and password for login
//
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(admin)
//                .when()
//                .post("/admins/adminLogin")
//                .then()
//                .extract().response();
//
//        Assertions.assertEquals(200, response.getStatusCode());
//        // Add additional assertions to validate the response body or structure
//    }
//
//    @Test
//    public void testCheckEmail() {
//        Admin admin = new Admin();
//        // Set the email to check
//
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(admin)
//                .when()
//                .post("/admins/checkEmail")
//                .then()
//                .extract().response();
//
//        Assertions.assertEquals(200, response.getStatusCode());
//        // Add additional assertions to validate the response body or structure
//    }
}
