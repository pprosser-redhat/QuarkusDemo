package io.quarkus.workshop.super_heroes_client;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class HeroClientResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hellohero/24")
          .then()
             .statusCode(200)
             .body("hello", is("Hello Buffy"));
    }

}