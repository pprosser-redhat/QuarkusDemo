package io.quarkus.workshop.super_heroes;

import java.util.List;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Path("/hero")
public class HeroResource {

    @Inject
    HeroService heroService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Hello")
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello RESTEasy");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<Hero>> getAllHeros(){
        return heroService.findAllHeros();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Uni<Response> gettHeroByid(@PathParam("id") Long id) {
        return Panache.withTransaction(() -> heroService.findHeroById(id)
            .onItem().ifNotNull().transform(entity -> Response.ok(entity).build())
            .onItem().ifNull().continueWith(Response.ok(NOT_FOUND)::build));
    }  

}