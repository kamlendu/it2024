<%-- 
    Document   : Home
    Created on : 20-Jan-2024, 11:59:28 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:out value="Hello World of JSTL/EL"/>
            <c:set var="x" value="10"/>
            <c:set var="y" value="20"/>
         <br/>   <c:out value="The value of x is ${x}"/>
         <br/>   <c:out value="The sum of 50 and 60 is ${50+60}"/>
          <br/>   <c:out value="The sum of x and y is ${x+y}"/>
          
          <br/>First Name = ${param.fname}
          <br/>Last Name = ${param.lname}
          <br/>Full Name = ${param.fname} ${param.lname}
          
          
          <br/>
          <c:forEach var="i" begin="1" end="10" step="1">
              <br> The square of  ${i} is ${i*i}
          </c:forEach>
              
              <c:forEach var="val" items="${paramValues.qual}">
               <br/>   ${val}
              </c:forEach>    
          
              
               
            
            
            
            
        </h1>
    </body>
</html>
