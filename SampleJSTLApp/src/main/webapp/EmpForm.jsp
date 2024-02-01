<%-- 
    Document   : EmpForm
    Created on : 20-Jan-2023, 11:40:49 AM
    Author     : root
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <fmt:setLocale value="hi_IN"/>
         <fmt:setBundle var="myvals" basename="myvalues"/>
        
        
    <center>
        <form action="Target.jsp" method="POST">
            <table width="50%">  
                <tr><td><fmt:message key="empno" bundle="${myvals}"/> : </td> 
                    <td> <input type="text" name="empno" value=""></td><td style="color:red"> </td></tr>
                <tr><td><fmt:message key="ename" bundle="${myvals}"/> :</td> 
                    <td> <input type="text" name="ename" value=""></td><td style="color:red">  </td></tr>
                <tr><td><fmt:message key="salary" bundle="${myvals}"/>:</td> 
                    <td> <input type="text" name="salary" value=""></td><td style="color:red">  </td></tr>
                <tr><td></td> <td><input type="submit" name="submit" value="Submit"></td><td></td></tr>
            </table>  

        </form>
    </center>
</body>
</html>
