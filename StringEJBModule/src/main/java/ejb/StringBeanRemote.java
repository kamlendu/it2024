/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface StringBeanRemote {
    
    String concat(String str1, String str2);
    
}
