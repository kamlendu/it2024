<%-- 
    Document   : conditional
    Created on : 20-Jan-2024, 12:20:22 PM
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
        <h3>
            <c:set var="x" value="17"/>       
            
            <c:if var="logic" test="${x <15}">
                <br/> X is less than 15
            </c:if> 
            <c:if var="logic" test="${x>15}">
                <br/> X is greater than 15
            </c:if>    
            <c:if var="logic" test="${x==15}">
                <br/> X is equal than 15
            </c:if> 
                
                
                <c:choose>
                    <c:when test="${x<20}">
                         <br/> ${x} is less than 20
                    </c:when>
                    <c:when test="${x>15}">
                         <br/> ${x} is greater than 20
                    </c:when>
                    <c:otherwise>
                         <br/> ${x} is equal to 20
                    </c:otherwise>
                </c:choose>      
            
            
            
            
        </h3>
    </body>
</html>
