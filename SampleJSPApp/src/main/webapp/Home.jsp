<%-- 
    Document   : Home
    Created on : 19-Jan-2024, 11:19:13 AM
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
        
        <%
            session.setAttribute("uname", "Vimal");
            application.setAttribute("company", "AMC Ltd");
            request.setAttribute("err", "There is an error in processing");
            
            %>
        
        <h1>Hello World!</h1>
    </body>
</html>
