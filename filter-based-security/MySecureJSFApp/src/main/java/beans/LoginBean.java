package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import record.KeepRecord;


/**
 *
 * @author root
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    @Inject SecurityContext ctx;
    
    private String username;
    private String password;
    private Set<String> roles;
    private String errorstatus;
    private AuthenticationStatus status;
    private String role;
    
    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public String getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(String errorstatus) {
        this.errorstatus = errorstatus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getErrorStatus() {
        return errorstatus;
    }

    public void setErrorStatus(String status) {
        this.errorstatus = status;
    }

    public String login()
    {
        try{
        FacesContext context = FacesContext.getCurrentInstance();
        
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
         HttpServletRequest request = (HttpServletRequest) FacesContext
                 .getCurrentInstance()
                 .getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
    AuthenticationStatus     mystatus=   ctx.authenticate(request, response, withParams().credential(credential));
     
     if(mystatus.equals(mystatus.SUCCESS))
        {
           // HttpSession session= request.getSession();
          //  session.setAttribute("username", username);
          //  session.setAttribute("password", password);
          
          KeepRecord.setUsername(username);
          KeepRecord.setPassword(password);
         
          System.out.println("Role:"+ ctx.getCallerPrincipal().getName()+" "+ ctx.isCallerInRole("Admin"));
          
        if(ctx.isCallerInRole("Admin"))
        {
            role="Admin";
            return "/admin/Admin";
        }
       else if(ctx.isCallerInRole("Supervisor"))
       {
           role="Supervisor";
            return "/user/User";
            
       
        }
        }
     else
     {
          errorstatus= "User Name or Password may be wrong";
          return "/Login";
     }
        }
        
        catch(Exception e)
        {
             errorstatus= "User Name or Password may be wrong";
            e.printStackTrace();
        }
        return "/Login";
    }
    /**
     * Creates a new instance of LoginBean
     */
    
    public String logout()
    {
        try{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session= request.getSession();
        request.logout();
       session.invalidate();
        KeepRecord.reset();
        return "/Login";
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        return "/Login";
    }
    public LoginBean() {
        
       // errorstatus="";
    }
    
   
    
  
}
