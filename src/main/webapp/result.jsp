<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Student Result</h2>

<p>Roll No: <%= request.getAttribute("rollno") %></p>
<p>Name: <%= request.getAttribute("name") %></p>

<p>Sub1: <%= request.getAttribute("sub1") %></p>
<p>Sub2: <%= request.getAttribute("sub2") %></p>
<p>Sub3: <%= request.getAttribute("sub3") %></p>
<p>Sub4: <%= request.getAttribute("sub4") %></p>
<p>Sub5: <%= request.getAttribute("sub5") %></p>

<h3>Average: <%= request.getAttribute("average") %></h3>

<h3>Result: 
    <%= request.getAttribute("result") %>
</h3>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>