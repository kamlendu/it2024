/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {
    
    void addCustomer(String fname, String lname);
    void updateCustomer(Integer id, String fname, String lname);
    void removeCustomer(Integer cid);
    
    Collection<Customer> getAllCustomers();
    Collection<Customer> getCustomersByFirstName(String fname);
    Collection<Customer> getCustomersByLastName(String lname);
    Collection<Customer> getCustomersBySubscription(Integer sid);
    
    void addAddressToCustomer(String street, String city, String state, String zip, Integer cid);
    void updateAddressToCustomer(Integer aid, String street, String city, String state, String zip, Integer cid);
    void removeAddressFromCustomer(Integer aid, Integer cid);
    
    Collection<Address> getAddressesOfCustomer(Integer cid);
    Collection<Address> getAddressesByCity(String city);
    Collection<Address> getAddressesByState(String state);
    Collection<Address> getAddressesByZip(String zip);
    
    void addSubscription(String title, String type);
    void updateSubscription(Integer sid, String title, String type);
    void removeSubscription(Integer sid);
    
    Collection<Subscription> getSubscriptionsOfCustomer(Integer cid);
    Collection<Subscription> getSubscriptionsByType(String type);
    Collection<Subscription> getSubscriptionsByTitle(String title);
    
    
    
    void addSubscriptionsToCustomer(Integer cid, List<Integer> sids);
    void removeSubscriptionsToCustomer(Integer cid, List<Integer> sids);
    
    
    
    
    
    
    
    
    
    
    
}
