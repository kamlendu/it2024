/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package record;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;

/**
 *
 * @author root
 */
@SessionScoped
public class KeepRecord implements Serializable {
    
    static CallerPrincipal principal;
    static Credential credential;
    static Set<String> roles;
    

    public KeepRecord() {
        
        principal=null;
        credential=null;
        roles=null;
    }

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        KeepRecord.principal = principal;
    }

    public static Credential getCredential() {
        return credential;
    }

    public static void setCredential(Credential credential) {
        KeepRecord.credential = credential;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        KeepRecord.roles = roles;
    }

   
    public static void reset()
    {
          principal=null;
        credential=null;
        roles=null;
    }
    
    
    
}
