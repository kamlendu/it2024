<%-- 
    Document   : Target
    Created on : 19-Jan-2024, 11:22:08 AM
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
        <h1>
            
             <h2>  
      Empno =  <%=emp.getEmpno()%> <br/>
      Ename =  <%=emp.getEname()%><br/>
      Salary =  <%=emp.getSalary()%>
        
        </h2>
            
            
            
      <br/>  User    <%=session.getAttribute("uname")%>
      <br/>  company    <%=application.getAttribute("company")%>
      <br/>  Error    <%=request.getAttribute("err")%>
      
                    
            
            
            
            
        </h1>
    </body>
</html>
