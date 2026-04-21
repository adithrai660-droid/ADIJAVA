<%--
7b. Construct a Cookie Management program using JSP to get the fields 
Name, Domain and Max Expiry Age (in seconds). --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
<title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(Cookie c : cookies){
        out.println("<b>Name:</b> " + c.getName() + "<br>");
        out.println("<b>Value:</b> " + c.getValue() + "<br>");
        out.println("<hr>");
    }
} else {
    out.println("<h3>No Cookies Found</h3>");
}
%>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>