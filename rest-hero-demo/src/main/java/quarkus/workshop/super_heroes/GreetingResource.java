package quarkus.workshop.super_heroes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * A simple JAX-RS resource that returns a JSON greeting.
 */
@Path("/hello")
public class GreetingResource {

    /**
     * Represents the JSON object that will be returned.
     * In modern Java, a record is a concise way to create a data-only class.
     * Quarkus handles the conversion from this record to JSON automatically.
     */
    public record Greeting(String message) {
    }

    /**
     * Handles HTTP GET requests to the /hello endpoint.
     *
     * @return a Greeting object which Quarkus automatically serializes into JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting hello() {
        return new Greeting("Hello from Quarkus!");
    }
}