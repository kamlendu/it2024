/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author root
 */
@Named(value = "person")
@RequestScoped
public class Person {
    
    String pname;
    String gender;
    String email;
    String city;
    String password;
    double salary;
    String [] hobbies;
    

    /**
     * Creates a new instance of Person
     */
    public Person() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void validateSalary(FacesContext ctx, UIComponent cmp, Object obj)
    {
        
        double sal = (Double) obj;
        
        if(sal < 2000)
        {
            FacesMessage msg = new FacesMessage("Salary cannot be less than 2000");
        
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            
            throw new ValidatorException(msg);
        
        }
        
    }
    
    
    
    
    
    
    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public String doShow()
    {
        return "Show.jsf";
    }
    
}
