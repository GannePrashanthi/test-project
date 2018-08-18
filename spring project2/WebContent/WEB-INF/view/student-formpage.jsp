<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
<form:form action="process3" modelAttribute="student">
first name:<form:input path="firstname" type="text" value="firstname"></form:input><br><br>

lastname:<form:input path="lastname" type="text" value="lastname"></form:input><br><br>


country:<form:select path="country">
<form:option lable="India" value="India"></form:option>
<form:option lable="Singapore" value="Singapore"></form:option>
<form:option lable="China" value="China"></form:option>
<form:option lable="America" value="America"></form:option>

</form:select>

<input type="submit" value="submit">

</form:form>
</body>
</html>
