<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<html>
<body>

<h2>Session Check Page</h2>

<%
    String name = (String) session.getAttribute("user");

    if (name == null) {
%>
        <h3 style="color:red;">Sorry, session has expired!</h3>
        <a href="index.html">Start Again</a>
<%
    } else {
%>
        <h3>Hello <%= name %>!</h3>
        <p>Your session is still active.</p>
<%
    }
%>

</body>
</html>