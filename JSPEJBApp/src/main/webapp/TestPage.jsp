<%-- 
    Document   : TestPage
    Created on : 31-Jan-2024, 11:56:35 AM
    Author     : root
--%>

<%@page contentType="text/html" import="javax.naming.*,javax.ejb.*,java.util.Properties, ejb.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%!
            
        StringBeanRemote sbr = null;
        ALocalBeanLocal al = null;
        InitialContext ic;
        InitialContext ic1;
        
        public void jspInit()
        {
        
        try{

             Properties p = new Properties();
               
                p.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                 p.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
               
                ic = new InitialContext(p);
           
                sbr = (StringBeanRemote) ic.lookup("ejb/str");
            
                ic1 = new InitialContext();

            al = (ALocalBeanLocal) ic1.lookup("java:global/JSPEJBApp/ALocalBean");
            
            




        }
    catch(Exception e)
    {
    e.printStackTrace();
    }

        }
        public void jspDestroy()
        {
            sbr=null;
            al= null;
        }
        
        
        
        %>
        <h1> <%=sbr.concat("MSCIT", "VNSGU") %> </h1>
        <h1> The product of 8 and 7 is <%=al.multiply(8, 7) %> </h1>
        
        
    </body>
</html>
