<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
<title>Cookie Created</title>
</head>
<body>

<h2>Cookie Information</h2>

<%
String name = request.getParameter("name");
String domain = request.getParameter("domain");
String ageStr = request.getParameter("age");

try {
    int age = Integer.parseInt(ageStr);

    // Create cookie
    Cookie cookie = new Cookie("userName", name);

    // Set properties
    cookie.setDomain(domain);
    cookie.setMaxAge(age);

    // Add cookie to response
    response.addCookie(cookie);

    out.println("<b>Name:</b> " + name + "<br>");
    out.println("<b>Domain:</b> " + domain + "<br>");
    out.println("<b>Max Age:</b> " + age + " seconds<br>");

} catch(Exception e) {
    response.setStatus(400);
    out.println("<h3 style='color:red;'>Invalid Input!</h3>");
}
%>

<br><br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>