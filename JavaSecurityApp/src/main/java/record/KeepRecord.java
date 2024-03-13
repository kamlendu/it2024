/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package record;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author root
 */
@SessionScoped
public class KeepRecord implements Serializable {
    
    static String username;
    static String password;

    public KeepRecord() {
        
        username=null;
        password=null;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        KeepRecord.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        KeepRecord.password = password;
    }
    
    public static void reset()
    {
        username=null;
        password=null;
    }
    
    
    
}
