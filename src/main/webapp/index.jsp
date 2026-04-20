<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Result Form</title>

    <script>
        function validateForm() {
            let fields = ["rollno","name","sub1","sub2","sub3","sub4","sub5"];

            for (let i = 0; i < fields.length; i++) {
                let value = document.forms["myForm"][fields[i]].value;

                if (value === "") {
                    alert("All fields are required!");
                    return false;
                }
            }

            // Check marks range
            for (let i = 1; i <= 5; i++) {
                let mark = document.forms["myForm"]["sub"+i].value;

                if (mark < 0 || mark > 100) {
                    alert("Marks must be between 0 and 100");
                    return false;
                }
            }

            return true;
        }
    </script>
</head>

<body>
<h2>Student Result Form</h2>

<form name="myForm" action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="sub1"><br>
Sub2: <input type="number" name="sub2"><br>
Sub3: <input type="number" name="sub3"><br>
Sub4: <input type="number" name="sub4"><br>
Sub5: <input type="number" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>
</body>
</html>