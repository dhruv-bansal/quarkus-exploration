package org.techpleiad.exploration.web;

import com.google.gson.Gson;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
class BookResourceITTest {

    @Test
    void testGetAllBooks() {

        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
                when()
                .get("/books").
                then()
                .statusCode(200)
                .body("size()", is(4));

    }

    @Test
    void testCountAllBooks() {

        Gson gson = new Gson();

        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
        when()
                .get("/books/count").
        then()
                .statusCode(200)
                .body(is(gson.toJson(4)));

    }
}