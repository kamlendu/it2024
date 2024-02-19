package it.restapp.resources;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @GET
   // @Produces(MediaType.TEXT_HTML)
     @Produces("text/html")
    public String sayHello(){
      
        return "<h4>Hello World of Web Services</h4>";
    }
    
   @GET
   @Path("anotherhello/{pname}")
   @Produces("text/html")
   public String sayAnotherHello(@PathParam("pname") String pname){
      
        return "<h4>Hello World of Web Services "+ pname + " !</h4>";
    }
   
   @PUT
   @Path("uppers")
   @Produces("application/json")
   @Consumes("application/json")
   public Collection<String> cuppers(Collection<String> strs){
      
       Collection<String> ups = new ArrayList<>();
       
       for(String str : strs)
       {
           ups.add(str.toUpperCase());
       }
       
        return ups;
    }
    
}
