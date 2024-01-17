/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author root
 */
//@WebListener
public class MyListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println(" Context Initialized .....");
        
        sce.getServletContext().setAttribute("company", "WAPCOS Ltd.");
       
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
         System.out.println(" Context Destroyed .....");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        
         System.out.println(" You have added attribute to the context with name "+ event.getName()+ " having value "+ event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        
               System.out.println(" You have removed attribute to the context with name "+ event.getName()+ " having value "+ event.getValue());
  
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
        System.out.println("Session created with session id = "+ se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
               System.out.println("Session destroyed... ");
 
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        
                System.out.println(" You have added attribute to the session with name "+ event.getName()+ " having value "+ event.getValue());
 
        
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        
                System.out.println(" You have removed attribute to the context with name "+ event.getName()+ " having value "+ event.getValue());
 
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        
      
    }
}
