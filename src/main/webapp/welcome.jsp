<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<%
    String name = request.getParameter("uname");
    String expiryStr = request.getParameter("expiry");
    int expiryTime = 60; // default 1 minute

    if (expiryStr != null && !expiryStr.isEmpty()) {
        try {
            expiryTime = Integer.parseInt(expiryStr);
        } catch (NumberFormatException e) {
            expiryTime = 60; // fallback
        }
    }

    session.setAttribute("user", name);
    session.setMaxInactiveInterval(expiryTime);

    out.print("<h2>Hello " + name + "!</h2>");
    out.print("<p>Your name has been stored in the session object.</p>");
    out.print("<p>Session expiry time is set to " + expiryTime + " seconds.</p>");
    out.print("<p>Press the following link to check it within the set time or wait for expiry:</p>");
%>

<a href="second.jsp">Display the session value</a>

</body>
</html>
