<%-- 
    Document   : data
    Created on : 23-Jan-2024, 10:52:18 AM
    Author     : root
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            <sql:setDataSource dataSource="jdbc/itdata"/>
                                     
            <sql:update var="insert">
                insert into  employee values (?,?,?)
                <sql:param value="150"/>
                <sql:param value="Amrendra"/>
                <sql:param value="73450"/>               
                
            </sql:update>   
            
            
            
          <sql:query  var="query">
                
              select * from employee
                               
          </sql:query> 
              
              <table border="1">  
              <c:forEach var="row" items="${query.rowsByIndex}">
                  <tr><td> ${row[0]} </td><td> ${row[1]}</td><td> ${row[2]}</td></tr>
              </c:forEach>
              </table>
            
            
            
            
            
            
            
            
        </h3>
    </body>
</html>
