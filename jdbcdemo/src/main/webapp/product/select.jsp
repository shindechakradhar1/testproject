<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="jdbcdemo.entities.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container">

	<h1>Select</h1>
	<table border=1>
	<%
		List<Student> students = (List<Student>) request.getAttribute("studentList");
		for(Student student:students){
			out.write("<tr>");
			out.write("<td>" + student.getId() + "</td>" );
			out.write("<td>" + student.getName() + "</td>" );
			out.write("<td>" + student.getAge() + "</td>" );
			out.write("<td><a href=update?id="+student.getId()+ ">update</a></td>" );
			out.write("<td><a href=delete?id="+student.getId()+ ">delete</a></td>" );
			out.write("</tr>");
			
		}
	%>
	</table>
</body>
</html>