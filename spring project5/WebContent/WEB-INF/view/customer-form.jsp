<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>customer form</title>
<style>
.error{color:red}
</style>
</head>
<body>
<form:form action="processurl1" modelAttribute="customer">
firstname:<form:input path="firstname"></form:input>
lastname(*):<form:input path="lastname"></form:input>
<form:errors path="lastname" cssClass="error"></form:errors>
<input type="submit" value="submit"/>

</form:form>
</body>
</html>