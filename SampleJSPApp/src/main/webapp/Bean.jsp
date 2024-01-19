<%-- 
    Document   : Bean
    Created on : 19-Jan-2024, 12:00:57 PM
    Author     : root
--%>
<jsp:useBean id="emp" class="bean.Employee" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:setProperty name="emp" property="empno" value="21"/>
        <jsp:setProperty name="emp" property="ename" value="Arun"/>
        <jsp:setProperty name="emp" property="salary" value="5000.00"/>
        
        <jsp:forward page="Target.jsp"/>
       
        
        <h1>Hello World!</h1>
    </body>
</html>
