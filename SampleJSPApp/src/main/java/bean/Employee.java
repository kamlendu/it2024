/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.Serializable;
import java.util.Hashtable;

/**
 *
 * @author root
 */
public class Employee implements Serializable {
    
    private int empno;
    private String ename;
    private double salary;
    Hashtable errors;

    public Employee() {
        
        empno=0;
        ename="";
        salary=0.0;
        errors = new Hashtable();
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
   public boolean validate() 
   {
       boolean allOK=true;
       
       if(empno==0)
       {
           allOK=false;
           errors.put("empno", "Empno can not be 0 or less");
       }
    if(ename.equals(""))
       {
           allOK=false;
           errors.put("ename", "Ename can not be blank");
       }
    if(salary<=0)
       {
           allOK=false;
           errors.put("salary", "Salary can not be 0 or less");
       }
    
    return allOK;
   }
   
   public String getError(String field)
   {
       String err = (String) errors.get(field.trim());
       
       return (err==null)?"":err;
   }
   
   
    

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

   
    
    
    
    
    
    
    
    
}
