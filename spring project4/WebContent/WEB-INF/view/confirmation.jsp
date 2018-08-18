<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<title>
Student Confirmation

</title>

</head>
<body>

Student Confirmed
<br><br>

${student.firstname}<br><br>
${student.lastname}
<br><br>
${student.country}

<br><br>
language:- ${student.favlang}
<br><br>
system
<ul>
<c:forEach var="temp" items="${student.operatingsystem}">
<li> ${temp} </li>
</c:forEach>
</ul>

</body>


</html>