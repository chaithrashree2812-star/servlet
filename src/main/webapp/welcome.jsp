<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<html>
<body>

<%
    String name = request.getParameter("uname");

    if (name != null && !name.isEmpty()) {

        // Store in session
        session.setAttribute("user", name);

        // Set session expiry (60 seconds)
        session.setMaxInactiveInterval(60);
%>

        <h2>Welcome <%= name %>!</h2>
        <p>Session has started...</p>
        <p>Your name has been stored in session object.</p>
        <p>Session expiry time is set to 1 minute.</p>

        <p>
            👉 <a href="second.jsp">Click here to check session</a>
        </p>

        <p>
            (Click within 1 minute OR wait for 1 minute to see session expiry)
        </p>

<%
    } else {
%>
        <h3>Please enter your name</h3>
        <a href="index.html">Go Back</a>
<%
    }
%>

</body>
</html>