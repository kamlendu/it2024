<%-- 
    Document   : First
    Created on : 18-Jan-2024, 12:06:43 PM
    Author     : root
--%>

<%@page contentType="text/html" import="java.sql.*,java.util.*" pageEncoding="UTF-8"%>
<%!
String fname;

String lname;

String fullName;
    
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include  file="Header.jsp" %>
        
        
        
        
        <%
            fname = request.getParameter("fname");
            lname= request.getParameter("lname");
            
            fullName = fname+" "+ lname;
            
            %>
        
        <%-- This is a comment --%>
                
        <h1> Hello World of JSP </h1>
        <h1>Today is <%= new java.util.Date().toString()%></h1>
       
        
        
        
        <h2> The full name is <%=fullName%>
        
        
        
        <table border="1">
            <tr><th>Number</th><th>Square</th></tr>   
        <%
            for(int i = 0; i<10; i++)
            {
            
            out.println("<tr><td>"+i+"</td><td>"+i*i+"</td></tr>");
        
                }
        %>
        
        </table>
        <%--
        <jsp:include page="Second.jsp">
            <jsp:param name="uname" value="Admin"/>
        </jsp:include>
        --%>
        <jsp:forward page="Second.jsp">
            <jsp:param name="uname" value="Admin"/>
        </jsp:forward>
        
        
        
    </body>
</html>
