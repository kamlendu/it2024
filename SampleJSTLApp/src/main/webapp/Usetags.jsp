<%-- 
    Document   : Usetags
    Created on : 24-Jan-2024, 11:25:35 AM
    Author     : root
--%>
<%@taglib  prefix="mytags" tagdir="/WEB-INF/tags/" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <mytags:curdate/>
        <br/> <mytags:ucase> a view from a room </mytags:ucase> 
        <br/><mytags:ccase alt="lower" company="ITCompany"> MSc iT vNSGU </mytags:ccase>
        
        <h1>Hello World!</h1>
    </body>
</html>
