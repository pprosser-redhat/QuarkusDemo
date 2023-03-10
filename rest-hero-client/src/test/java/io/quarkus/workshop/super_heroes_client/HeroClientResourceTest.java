package io.quarkus.workshop.super_heroes_client;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class HeroClientResourceTest {

    // start jvm without debug mode to avoid clash with rest api in dev mode
    // -Ddebug=false
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hellohero/2147")
          .then()
             .statusCode(200)
             .body("hello", is("Hello Chewbacca"));
    }

}