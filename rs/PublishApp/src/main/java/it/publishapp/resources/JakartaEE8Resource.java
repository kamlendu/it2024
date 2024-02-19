package it.publishapp.resources;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    @EJB PublishBeanLocal pbl;
   
     
    @POST
    @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname,@PathParam("lname") String lname) {
        pbl.addCustomer(fname, lname);
    }

    @DELETE
    @Path("remcust/{cid}")
    public void removeCustomer(@PathParam("cid") Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       pbl.removeCustomer(cid);
    }

    @GET 
    @Produces("application/json")
    public Collection<Customer> getAllCustomers() {
     
        return pbl.getAllCustomers();
    }

    @GET
    @Path("getcustbyfname/{fname}")
    @Produces("application/json")
    public Collection<Customer> getCustomersByFirstName(@PathParam("fname") String fname) {
    
        return pbl.getCustomersByFirstName(fname);
    }

     
   
    @GET
    @Path("getcustbysub/{sid}")
    @Produces("application/json")
    public Collection<Customer> getCustomersBySubscription(@PathParam("sid") Integer sid) {
    
        return pbl.getCustomersBySubscription(sid);
    }

    @POST
    @Path("addaddresstocust/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street, @PathParam("city") String city, @PathParam("state") String state,@PathParam("zip") String zip, @PathParam("cid") Integer cid) {
     
        pbl.addAddressToCustomer(street, city, state, zip, cid);
    }

     
   
    @DELETE
    @Path("remaddofcust/{aid}/{cid}")
    public void removeAddressFromCustomer(@PathParam("aid") Integer aid, @PathParam("cid") Integer cid) {
     
    pbl.removeAddressFromCustomer(aid, cid);
    }

    @GET
    @Path("getaadreessesofcust/{cid}")
    @Produces("application/json")
    public Collection<Address> getAddressesOfCustomer(@PathParam("cid") Integer cid) {
     
    return pbl.getAddressesOfCustomer(cid);
    }

   
    @POST
    @Path("addsubs/{title}/{type}")
    public void addSubscription(@PathParam("title") String title,@PathParam("type") String type) {
    
        pbl.addSubscription(title, type);
    }

     
   
     @DELETE
     @Path("remsubs/{sid}")
    public void removeSubscription(@PathParam("sid") Integer sid) {
       pbl.removeSubscription(sid);
    }

    @GET
    @Path("getsubsofcust/{cid}")
    @Produces("application/json")
    public Collection<Subscription> getSubscriptionsOfCustomer(@PathParam("cid") Integer cid) {
      
        return pbl.getSubscriptionsOfCustomer(cid);
    }

     
    
     @POST
     @Path("addsubstocust/{cid}")
     @Produces("application/json")
     @Consumes("application/json")
    public void addSubscriptionsToCustomer(@PathParam("cid") Integer cid, Collection<Integer> sids) {
       
        pbl.addSubscriptionsToCustomer(cid, sids);
    }

    
    @POST
     @Path("remsubstocust/{cid}")
     @Produces("application/json")
     @Consumes("application/json")
    public void removeSubscriptionsToCustomer(@PathParam("cid") Integer cid, Collection<Integer> sids) {
      
        pbl.removeSubscriptionsToCustomer(cid, sids);
    }
   
}
