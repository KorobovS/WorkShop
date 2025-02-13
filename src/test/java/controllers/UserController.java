package controllers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UserController {

    RequestSpecification requestSpecification;
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private static final String USER_ENDPOINT = "user";

    public UserController() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL);
    }

    public Response createUser(User user) {
        return given(this.requestSpecification)
                .body(user)
                .when()
                .post(USER_ENDPOINT)
                .andReturn();
    }

//    public Response updateUser(User user) {
//        return given(this.requestSpecification)
//                .body(user)
//                .when()
//                .post(USER_ENDPOINT + "/" + user.getUsername())
//                .andReturn();
//    }
//
//    public Response getUserByUsername(String username) {
//        return given(this.requestSpecification)
//                .when()
//                .get(USER_ENDPOINT + "/" + username)
//                .andReturn();
//    }
//
//    public Response deleteUserByUsername(String username) {
//        return given(this.requestSpecification)
//                .when()
//                .delete(USER_ENDPOINT + "/" + username)
//                .andReturn();
//    }
}
