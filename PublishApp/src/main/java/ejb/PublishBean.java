/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishBean implements PublishBeanLocal {
    
    @PersistenceContext(unitName = "publishpu")
    EntityManager em;

    @Override
    public void addCustomer(String fname, String lname) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Customer c = new Customer();
        c.setFirstName(fname);
        c.setLastName(lname);
        
        em.persist(c);
    
    
    }

    @Override
    public void updateCustomer(Integer id, String fname, String lname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeCustomer(Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, cid);
    
        em.remove(c);
    }

    @Override
    public Collection<Customer> getAllCustomers() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    return em.createNamedQuery("Customer.findAll").getResultList();
    
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String fname) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return em.createNamedQuery("Customer.findByFirstName")
            .setParameter("firstName", fname)
            .getResultList();
    
    }

    @Override
    public Collection<Customer> getCustomersByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Customer> getCustomersBySubscription(Integer sid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s = (Subscription) em.find(Subscription.class, sid);
    
    return s.getCustomerCollection();
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer cid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      Customer c = (Customer) em.find(Customer.class, cid);
      Collection<Address> addresses = c.getAddressCollection();
      
    Address a = new Address();
    
    a.setStreet(street);
    a.setCity(city);
    a.setState(state);
    a.setZip(zip);
    a.setCustomerId(c);
    
    addresses.add(a);
    c.setAddressCollection(addresses);
    
    em.persist(a);
    em.merge(c);
    
    
    
    
    
    
    
    }

    @Override
    public void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAddressFromCustomer(Integer aid, Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Customer c = (Customer) em.find(Customer.class, cid);
   
    Collection<Address> addresses = c.getAddressCollection();
    
    Address a = (Address) em.find(Address.class, aid);
    
    if(addresses.contains(a))
    {
    
        addresses.remove(a);
        c.setAddressCollection(addresses);
        
        em.remove(a);
    
    }
    
    
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer cid) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Customer c = (Customer) em.find(Customer.class, cid);
  
     return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscription(String title, String type) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      Subscription s = new Subscription();
      
      s.setTitle(title);
      s.setType(type);
      
      em.persist(s);
    
    }

    @Override
    public void updateSubscription(Integer sid, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(Integer sid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Subscription s = (Subscription) em.find(Subscription.class, sid);
       
       em.remove(s);
    
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer cid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, cid);
  
    return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getSubscriptionsByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscriptionsToCustomer(Integer cid, Collection<Integer> sids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, cid);
      Collection<Subscription> subs = c.getSubscriptionCollection();
      
      for( Integer sid : sids)
      {
         Subscription s = (Subscription) em.find(Subscription.class, sid);
      
         if(!subs.contains(s))
         {
             Collection<Customer> custs = s.getCustomerCollection();
             subs.add(s);
             custs.add(c);
             
             c.setSubscriptionCollection(subs);
             s.setCustomerCollection(custs);
             
             em.merge(c);
         }
       
      }
    }

    @Override
    public void removeSubscriptionsToCustomer(Integer cid, Collection<Integer> sids) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, cid);
      Collection<Subscription> subs = c.getSubscriptionCollection();
      
      for( Integer sid : sids)
      {
         Subscription s = (Subscription) em.find(Subscription.class, sid);
      
         if(subs.contains(s))
         {
             Collection<Customer> custs = s.getCustomerCollection();
             subs.remove(s);
             custs.remove(c);
             
             c.setSubscriptionCollection(subs);
             s.setCustomerCollection(custs);
             
             em.merge(c);
         }
       
      }
    
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")




}
