package io.quarkus.workshop.super_heroes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

@Path("/hero")
@SecuritySchemes(value = {
    @SecurityScheme(securitySchemeName = "hero-key", type=SecuritySchemeType.APIKEY, apiKeyName = "user-key", in = SecuritySchemeIn.HEADER)
})
public class HeroResource {

    @Inject HeroService heroService;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    @SecurityRequirement(name = "hero-key")
    public String hello() {
        return "hello phil";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @SecurityRequirement(name = "hero-key")
    public Response getheroes() {
        return Response.ok(heroService.findAllHeros()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @SecurityRequirement(name = "hero-key")
    public Response getherobyid(@PathParam("id") Long id) {
        return Response.ok(heroService.findHeroById(id)).build();
    }
}