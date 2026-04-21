<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
<h2>Student Result</h2>

<%
String rollno = (String) request.getAttribute("rollno");
String studentname = (String) request.getAttribute("studentname");
int[] marks = (int[]) request.getAttribute("marks");
double average = (double) request.getAttribute("average");
String result = (String) request.getAttribute("result");
%>

<p>Roll No: <%= rollno %></p>
<p>Student Name: <%= studentname %></p>
<p>Marks:</p>
<ul>
    <li>Subject 1: <%= marks[0] %></li>
    <li>Subject 2: <%= marks[1] %></li>
    <li>Subject 3: <%= marks[2] %></li>
    <li>Subject 4: <%= marks[3] %></li>
    <li>Subject 5: <%= marks[4] %></li>
</ul>

<p>Average Marks: <%= average %></p>
<p>Result: <b><%= result %></b></p>

<br/>
<a href="index.jsp">Go back to Input Page</a>

</body>
</html>
