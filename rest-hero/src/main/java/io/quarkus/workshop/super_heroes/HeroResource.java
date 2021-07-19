package io.quarkus.workshop.super_heroes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hero")
public class HeroResource {

    @Inject HeroService heroService;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello phil";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getheroes() {
        return Response.ok(heroService.findAllHeros()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getherobyid(@PathParam("id") Long id) {
        return Response.ok(heroService.findHeroById(id)).build();
    }
}