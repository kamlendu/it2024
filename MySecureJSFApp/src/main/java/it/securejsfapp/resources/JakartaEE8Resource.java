package it.securejsfapp.resources;

import ejb.SecureBean;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author 
 */
@DeclareRoles("Admin")
@Path("rest")
public class JakartaEE8Resource {
    @EJB SecureBean sb;
    @Context
    private UriInfo context;
    
   @RolesAllowed({"Admin"})
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        //TODO return proper representation object
       // throw new UnsupportedOperationException();
       return sb.saySecureHello()+ " from Rest Client";
    }

    }

