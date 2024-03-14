/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable  {

@Inject IdentityStoreHandler handler; 

CredentialValidationResult result;

AuthenticationStatus status;
    
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       
     try {
            if (request.getRequestURI().contains("Logout")) {
                request.logout();
                KeepRecord.reset();
                response.sendRedirect("index.jsp");
                return ctx.doNothing();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
       
       try{
       if(request.getParameter("username")!=null)
       {
       
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           
           Credential credential = new UsernamePasswordCredential(username, new Password(password));
      
           result= handler.validate(credential);
           
         status =  ctx.notifyContainerAboutLogin(result);
           
           
           if(result.getStatus()== CredentialValidationResult.Status.VALID)
           {
              KeepRecord.setPrincipal(result.getCallerPrincipal());
              KeepRecord.setCredential(credential);
              KeepRecord.setRoles(result.getCallerGroups());
            request.setAttribute("user", result.getCallerPrincipal().getName());
                
            if(result.getCallerGroups().contains("Admin")) 
            { 
               request.getRequestDispatcher("/admin.jsp").forward(request, response);
               return status;
            }
            else if(result.getCallerGroups().contains("Supervisor")) 
            { 
               request.getRequestDispatcher("/users.jsp").forward(request, response);
                return status;
            }
         
           }
           
           else {
               
               request.setAttribute("error", "Either username of password is wrong !!");
               request.getRequestDispatcher("/index.jsp").forward(request, response);
           
               //return ctx.doNothing();
           
           }
           
       }
       
       if(KeepRecord.getPrincipal()!=null)
       {
            result = handler.validate(KeepRecord.getCredential());
       
          status= ctx.notifyContainerAboutLogin(result);
           return status;
       }
       
       
       
       
       }
       catch(Exception e)
       {
            return ctx.doNothing();
       }
    return ctx.doNothing();
    }
    




}
