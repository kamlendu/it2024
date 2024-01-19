<%-- 
    Document   : Second
    Created on : 19-Jan-2024, 11:28:58 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>The Second Page </h1><br/>
        
        User Name = <%= request.getParameter("uname")%>
                
        
    </body>
</html>
