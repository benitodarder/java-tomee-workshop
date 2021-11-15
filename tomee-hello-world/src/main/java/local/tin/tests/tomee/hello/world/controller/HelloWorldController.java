package local.tin.tests.tomee.hello.world.controller;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import local.tin.tests.tomee.hello.world.services.HellWorldService;

/**
 *
 * @author benitodarder
 */

@Path("/helloWorld")
public class HelloWorldController {

    @Inject
    private HellWorldService helloWorldServiceImpl;
    
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloWorld() {

        return Response.status(Response.Status.OK).type(MediaType.TEXT_PLAIN).entity(helloWorldServiceImpl.getGenericGreeting()).build();
    }

    @GET
    @Path("/withArgument")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloGET(@QueryParam("argument") String argument) {

        return Response.status(Response.Status.OK).type(MediaType.TEXT_PLAIN).entity(helloWorldServiceImpl.getNamedGreeting(argument)).build();
    }

    @POST
    @Path("/withArgument")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloPOST(String argument) {

        return Response.status(Response.Status.OK).type(MediaType.TEXT_PLAIN).entity(helloWorldServiceImpl.getNamedGreeting(argument)).build();
    }
}
