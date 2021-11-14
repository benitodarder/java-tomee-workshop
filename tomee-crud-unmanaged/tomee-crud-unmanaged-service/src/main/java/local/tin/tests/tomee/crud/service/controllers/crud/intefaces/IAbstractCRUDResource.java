package local.tin.tests.tomee.crud.service.controllers.crud.intefaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import local.tin.tests.tomee.crud.model.domain.interfaces.IIdentifiable;


/**
 *
 * @author benitodarder
 * @param <C>
 */
public interface IAbstractCRUDResource<C extends IIdentifiable> {
    
    @GET
    @Path("retrieveAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response retrieveAll();   
    
    @POST
    @Path("retrieve")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response retrieve(C parameter);  
    
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(C parameter);
    
    @POST
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response delete(C parameter);    
    
    @POST
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(C parameter);  
        
    
}
