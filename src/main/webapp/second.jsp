<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Check</title>
</head>
<body>

<h2>Display the session value on this page</h2>

<%
    String name = (String) session.getAttribute("user");

    if (name == null) {
        out.print("<p style='color:red;'>Sorry, the session has expired.</p>");
    } else {
        out.print("<p style='color:blue;'>Hello " + name + "!</p>");
    }
%>

</body>
</html>
