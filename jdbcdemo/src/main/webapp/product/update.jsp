<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container">
	<form method="post" action="update">
		<input type="text" name="sid" value="${student.getId()}" > 
		<input type="text" name="sname" value="${student.getName()}">
		<input type="text" name="sage" value="${student.getAge()}">
		<button type="submit">submit</button>
	</form>
</body>
</html>