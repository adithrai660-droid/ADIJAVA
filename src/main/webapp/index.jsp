<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Marks Entry</title>
<script type="text/javascript">
// Client-side validation
function validateForm() {
    var rollno = document.forms["studentForm"]["rollno"].value;
    var name = document.forms["studentForm"]["studentname"].value;
    var subjects = ["sub1","sub2","sub3","sub4","sub5"];

    if (rollno == "" || isNaN(rollno)) {
        alert("Roll number must be a number");
        return false;
    }
    if (name == "") {
        alert("Student name must be filled out");
        return false;
    }
    for (var i=0; i<subjects.length; i++) {
        var mark = document.forms["studentForm"][subjects[i]].value;
        if (mark == "" || isNaN(mark) || mark < 0 || mark > 100) {
            alert("Enter valid marks (0-100) for " + subjects[i]);
            return false;
        }
    }
    return true;
}
</script>
</head>
<body>
<h2>Enter Student Details</h2>
<form name="studentForm" action="ResultServlet" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="rollno"><br/><br/>
    Student Name: <input type="text" name="studentname"><br/><br/>
    Subject 1: <input type="text" name="sub1"><br/>
    Subject 2: <input type="text" name="sub2"><br/>
    Subject 3: <input type="text" name="sub3"><br/>
    Subject 4: <input type="text" name="sub4"><br/>
    Subject 5: <input type="text" name="sub5"><br/><br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
