<%-- 
    Document   : formating
    Created on : 23-Jan-2024, 11:15:59 AM
    Author     : root
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" import="java.util.Date" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            <fmt:setLocale value="hi_IN"/>
            <fmt:setBundle var="myvals" basename="myvalues"/>
            
            <h2> Greeting : <fmt:message key="greeting" bundle="${myvals}"/> </h2>
            
                <h4> Company : <fmt:message key="company" bundle="${myvals}"/> </h2>
        
                 <h4> Address : <fmt:message key="address" bundle="${myvals}"/> </h2>
        
            
            
            
            
            
            
            
            
            
            <%
                request.setAttribute("curdate", new Date() );

                %>
            
                <br>   The current date is  : ${curdate}
                
                <c:set var="x" value="123654.76432"/>
                
                
                
                
                <fmt:setLocale value="hi_IN"/>
                
           <br/>     <fmt:formatDate type="date" value="${curdate}"/>
           <br/>     <fmt:formatDate type="both" value="${curdate}"/>
             <br/>     <fmt:formatDate type="time" value="${curdate}"/>
         
           <br/>     <fmt:formatDate pattern="dd-MMM-YYYY hh:mm:ss" type="both" value="${curdate}"/>
           
      <br/> <br/><br/><br/><br/>    
      
      <fmt:formatNumber maxFractionDigits="2" value="${x}"/>
      <br/>    <fmt:formatNumber maxIntegerDigits="3" value="${x}"/>
           
           
           
                
                
        
      
                
                
            
            
            
        </h3>
    </body>
</html>
