 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <!DOCTYPE html>
<html>
<head>
<title>CUSTOMER REGISTRATION FORM</title>
<style>
.error{color:red}
</style>
</head>
<body>
<form:form action="processurlc" modelAttribute="customer">
first name:<form:input path="firstname"></form:input>
<br>
lastname(*):<form:input path="lastname"></form:input>
<form:errors path="lastname" cssClass="error"></form:errors>
<br><br>
freepasses:<form:input path="freepasses"/>
<form:errors path="freepasses" cssClass="error"></form:errors>
<br><br>
postal code:<form:input path="postalcode"/>
<form:errors path="postalcode" cssClass="error"></form:errors>

<br><br>
Course code:<form:input path="coursecode"/>
<form:errors path="coursecode" cssClass="error"></form:errors>

<input type="submit" value="submit"/>
</form:form>
</body>
</html>