<%-- 
    Document   : Books
    Created on : 19-Jan-2024, 11:15:58 AM
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
        <h1>
            
            <br> Book Name : <%= request.getParameter("bname")%>
             <br> Author Name : <%= request.getParameter("authname")%>
              <br> Publisher Name : <%= request.getParameter("pname")%>
               <br> Synopsis : <%= request.getParameter("synopsis")%>
            
            
            
            
            
            
            
            
            
        </h1>
    </body>
</html>
