package quarkus.workshop.super_heroes;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/heroes")
public class HeroResource {

    @Inject
    HeroService heroService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHeroes(){
        return Response.ok(heroService.findAllHeroes()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getHerobyId (@PathParam("id") Long id){
        return Response.ok().entity(heroService.findHeroById(id)).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
