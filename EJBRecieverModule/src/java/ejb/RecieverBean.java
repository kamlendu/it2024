/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import java.util.Properties;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/itqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecieverBean implements MessageListener {
    
    public RecieverBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
         String msg=null;
        try{
            
          if(message instanceof TextMessage)
          {
               msg = ((TextMessage)message).getText();
         
             System.out.println("Reciever  Bean has got the message -- " + msg);
          }
          
          
                
                Properties p = new Properties();
                p.setProperty(Context.PROVIDER_URL, "mq://localhost:7676");
                
              //========  Sending a Queue Message ============
                
                InitialContext ic = new InitialContext(p);
                
                Queue queue = (Queue) ic.lookup("jms/mware");
                ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/mwareFactory");
                Connection con = cf.createConnection();
                Session session = con.createSession();
                MessageProducer mp = session.createProducer(queue);
                TextMessage tm = session.createTextMessage();
                tm.setText("Reciever Bean has recieved your Message .."+msg);
                mp.send(tm);
            
            
        
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
    }
    
}
