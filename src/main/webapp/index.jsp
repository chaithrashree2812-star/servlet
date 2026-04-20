<html>
<head>
    <title>Cookie Management</title>
</head>
<body>

<h2>Add Cookie</h2>

<form action="setCookie.jsp" method="post">
    Name: <input type="text" name="name" required><br><br>
    Domain: <input type="text" name="domain" required><br><br>
    Max Expiry Age (seconds): <input type="number" name="age" required><br><br>
    
    <input type="submit" value="Add Cookie">
</form>

<br>
<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>