<%-- 
    Document   : Scopes
    Created on : 20-Jan-2024, 12:31:19 PM
    Author     : root
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("name", "Arvind");
            request.setAttribute("name", "Joy");
            session.setAttribute("name", "Mohit");
            application.setAttribute("name", "Sachin");
        
        
        %>
        <h2>
            <br/> Page Name : ${pageScope.name}
            <br/> Request Name : ${requestScope.name}
            <br/> Session Name : ${sessionScope.name}
            <br/> Application Name : ${applicationScope.name}
             
            
            
            
            
            
            
        </h2>
    </body>
</html>
