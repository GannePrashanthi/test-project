<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Confirmation page</title>
</head>
<body>
The student is confirmed:${customer.firstname} ${customer.lastname}
<br><br>
freepasses:${customer.freepasses}
<br><br>
postalcode:${customer.postalcode}
<br><br>
CourseCode:${customer.coursecode}
</body>


</html>