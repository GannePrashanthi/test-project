<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>REGISTRATION FORM</title>
</head>
<body>
<form:form action="processurl" modelAttribute="student">
firstname:<form:input path="firstname"></form:input><br>
lastname:<form:input path="lastname"></form:input><br>
country:<form:select path="country">
<form:options items= "${student.countryoptions}" />
</form:select>
favouritelanguage:
java:<form:radiobutton path="favlang" value="java"/>
C:<form:radiobutton path="favlang" value="C"/>
python:<form:radiobutton path="favlang" value="python"/>
ruby:<form:radiobutton path="favlang" value="ruby"/>
<br>
 operatingsystem:
linux:<form:checkbox path="operatingsystem" value="linux"/>
windows:<form:checkbox path="operatingsystem" value="windows"/>
mac:<form:checkbox path="operatingsystem" value="mac"/> 


<input type="submit" value="submit"/>
</form:form>
</body>
</html>