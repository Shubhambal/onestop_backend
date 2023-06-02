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

import static io.restassured.RestAssured.given;

public class AdminControllerTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Update the base URL to match your application's URL
    }

    @Test
    public void testGetAdminById() {
        int adminId = 4; // Update with an existing admin ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/admins/" + adminId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testCreateAdmin() {
        Admin admin = new Admin();
        admin.setUsername("ss");
        admin.setPassword("123");
        admin.setFirstName("shubham");
        admin.setLastName("Bal");
        admin.setEmailId("shubham@gmail.com");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(admin)
                .when()
                .post("/admins/create")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }


    @Test
    public void testUpdateAdmin() {
        int adminId = 4; // Update with an existing admin ID
        Admin admin = new Admin();
        // Set the updated properties of the Admin object

        Response response = given()
                .contentType(ContentType.JSON)
                .body(admin)
                .when()
                .put("/admins/update/" + adminId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        // Add additional assertions to validate the response body or structure
    }

    @Test
    public void testDeleteAdmin() {
        int adminId = 6; // Update with an existing admin ID

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/admins/delete/" + adminId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
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
