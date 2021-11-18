package io.quarkus.workshop.super_heroes_client;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkiverse.cxf.annotation.CXFClient;
import io.quarkus.workshop.super_heroes_client.api.ApiException;
import io.quarkus.workshop.super_heroes_client.api.HeroAPI;
import io.quarkus.workshop.super_heroes_client.soap.HeroService;

@Path("/hellohero")
@ApplicationScoped
public class HeroClientResource {

    @Inject
    @CXFClient("heroService")
    HeroService heroService;

    @Inject
    @RestClient
    HeroAPI heroAPI;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Hello hello(@PathParam("id") long id) throws ProcessingException, ApiException {
        
        return new Hello("Hello " + heroService.heroById(id).name);
        //return new Hello("Hello " + heroAPI.heroIdGet(id).getName());
        //return new Hello("Hello " + "Phil");
    }
}