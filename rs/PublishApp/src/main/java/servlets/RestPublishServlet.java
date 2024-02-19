/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import client.RestPublishClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(name = "RestPublishServlet", urlPatterns = {"/RestPublishServlet"})
public class RestPublishServlet extends HttpServlet {
    
    RestPublishClient pbl;
    Response rs;
    Collection<Customer> customers;
    Collection<Address> addresses;
    Collection<Subscription> subs;
    
    GenericType<Collection<Customer>> gcustomers;
    GenericType<Collection<Address>> gaddresses;
    GenericType<Collection<Subscription>> gsubs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestPublishServlet</title>");            
            out.println("</head>");
            out.println("<body><h4>");
            
            pbl = new RestPublishClient();
            customers = new ArrayList<>();
            addresses = new ArrayList<>();
            subs = new ArrayList<>();
            
            gcustomers = new GenericType<Collection<Customer>>(){};
            gaddresses = new GenericType<Collection<Address>>(){};
            gsubs = new GenericType<Collection<Subscription>>(){};
            
            
            
          //   pbl.addCustomer("Arvind", "Pandya");
          // pbl.removeCustomer("18");
           
          // pbl.addAddressToCustomer("M-451", "Vadodara", "Gujarat", "387631", "18");
          // pbl.addAddressToCustomer("Downing street", "London", "Brampton", "812345", "18");
           
          // pbl.removeAddressFromCustomer("16", "18");
          // pbl.removeAddressFromCustomer("17", "18");
           
           
           Collection<Integer> sids = new ArrayList<>();
           sids.add(3);
           sids.add(4);
           sids.add(5);
           
          // pbl.addSubscriptionsToCustomer(sids, "18");
        //pbl.removeSubscriptionsToCustomer(sids, "18");
        
        
        
            rs = pbl.getAllCustomers(Response.class);
            
            customers = rs.readEntity(gcustomers);
           
            for(Customer c : customers)
            {
                
              out.println("cid = "+ c.getCustomerID()+ " Name = "+ c.getFirstName()+ " "+ c.getLastName());
           
            rs = pbl.getAddressesOfCustomer(Response.class, c.getCustomerID().toString());
              
              addresses = rs.readEntity(gaddresses);
            for(Address a : addresses)
            {
                out.println("<br/>aid = "+ a.getAddressId() + " Street : "+ a.getStreet()+ " City : "+ a.getCity()+ " State : "+ a.getState()+ " zip : "+ a.getZip() );
            }
            
            rs = pbl.getSubscriptionsOfCustomer(Response.class, c.getCustomerID().toString());
            
             subs = rs.readEntity(gsubs);
            
            for(Subscription s : subs)
            {
                out.println("<br/>sid : "+ s.getSubscriptionId()+ " Title : "+ s.getTitle()+ " Type : "+ s.getType());
            }
            
            out.println("<hr/>");
            
            
            }
            out.println("</h4><h1>Servlet RestPublishServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            
            
            
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
