package io.quarkus.workshop.super_heroes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HeroResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hero/Hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}