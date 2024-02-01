<%-- 
    Document   : ucase
    Created on : 24-Jan-2024, 11:28:14 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<jsp:doBody var="content"/>

<%-- any content can be specified here e.g.: --%>
<h2>
    <%
  
    String txt = jspContext.getAttribute("content").toString();
    
    out.println(txt.toUpperCase());
    
    %>
</h2>