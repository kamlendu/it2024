/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package ejb;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionManagement(TransactionManagementType.BEAN)
@AccessTimeout(unit = TimeUnit.SECONDS, value = 30)
@Startup
@Singleton
@DependsOn({"FirstBean", "SecondBean"})
public class SingleBean {
    
    @Resource UserTransaction utx;
    
    String fname;
    String lname;
    String fullName;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @PostConstruct
    public void initialize()
    {
        this.fname="Rahul";
        this.lname="Patel";
        System.out.println("Single Bean is instantiated ....");
    }
    
    
    @Lock(LockType.READ)
    public String getFname() {
        return fname;
    }
    @Lock(LockType.WRITE)
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    @Lock(LockType.READ)
    public String getLname() {
        return lname;
    }

     @Lock(LockType.WRITE)
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFullName()
    {
        try{
        this.fullName= this.fname+" "+ this.lname;
        utx.commit();
        }
        catch(Exception e)
        {
          try{  
            utx.setRollbackOnly();
          }
          catch(Exception  tx)
          {
              tx.printStackTrace();
          }
      
        }
   
        return fullName;
        
    }







}
