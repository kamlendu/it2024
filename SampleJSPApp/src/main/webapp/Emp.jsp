<%-- 
    Document   : Emp
    Created on : 19-Jan-2024, 12:11:26 PM
    Author     : root
--%>
<jsp:useBean id="emp" class="bean.Employee" scope="request">
    <jsp:setProperty name="emp" property="*"/>
</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        if(emp.validate())
        {
        %>
         <h2>  
      Empno =  <%=emp.getEmpno()%> <br/>
      Ename =  <%=emp.getEname()%><br/>
      Salary =  <%=emp.getSalary()%>
        
        </h2>
      <%
          } 
          else
            {       
        %>
        <jsp:forward page="EmpForm.jsp"/>
        <%
            }
            %>
        
        <h1>Hello World!</h1>
    </body>
</html>
