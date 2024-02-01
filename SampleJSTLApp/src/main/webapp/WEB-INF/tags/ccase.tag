<%-- 
    Document   : ccase
    Created on : 24-Jan-2024, 11:33:04 AM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="alt"%>
<%@attribute name="company"%>

<jsp:doBody var="content"/>

<%-- any content can be specified here e.g.: --%>
<h2>
    
    <%
    
   String cmp = jspContext.getAttribute("company").toString();
        String attr = jspContext.getAttribute("alt").toString();
     String txt = jspContext.getAttribute("content").toString();
     
     if(attr.equalsIgnoreCase("upper"))
     {
        out.println(cmp+" "+txt.toUpperCase());
     }
     else if(attr.equalsIgnoreCase("lower"))
     {
        out.println(cmp+" "+txt.toLowerCase());
        
     }
     else
     {
      out.println("Error --- (only upper and lower are permitted");
    }


    
    %>
</h2>