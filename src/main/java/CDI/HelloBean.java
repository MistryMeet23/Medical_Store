/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CDI;

import Client.SecureClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author root
 */
@Named(value = "helloBean")
//@RequestScoped
public class HelloBean {
    
    SecureClient cl;
    String secureHello;
    String message="";

    
    public String getMessage() {
        return message;
       
    }

    /**
     * Creates a new instance of HelloBean
     */
    public void setMessage(String message) {    
        this.message = message;
    }

    public HelloBean() {
    }

    public String getSecureHello() {
        try{
         cl = new SecureClient();
         message="";
            System.out.println("inside Try Block");
        return cl.sayHello();
        }
        catch(Exception e)
        {
            System.out.println("inside Catch Block");
             message="";
            setMessage("You are Forbidden to access"); 
            System.err.println(message);
        }
        return "hello";
     }

    public void setSecureHello(String secureHello) {
        this.secureHello = secureHello;
    }
  
}
