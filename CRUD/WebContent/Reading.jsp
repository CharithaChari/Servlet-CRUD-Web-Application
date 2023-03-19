<%@page import="org.manu.CRUDApp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet' href='ReadingCss.css'>
</head>
<body>
	<%
		Student student = (Student) session.getAttribute("student");
		if (student != null) {
	%>
	<div class='login-box'>
		<h1>
			Hi,
			<%=student.getName()%></h1>
		<br>
		<table>
			<tr>
				<td><label class='A'>Email</label></td>
				<td><label class='B'>:<%=student.getEmail()%></label></td>
			</tr>
			<tr>
				<td><label class='A'>Phone</label></td>
				<td><label class='B'>:<%=student.getPhone()%></label></td>
			</tr>
			<tr>
				<td><label class='A'>Department</label></td>
				<td><label class='B'>:<%=student.getDept()%></label></td>
			</tr>
			<tr>
				<td><label class='A'>College</label></td>
				<td><label class='B'>:<%=student.getCollage()%></label></td>
			</tr>
			<br>
			<br>
			<tr>
				<td><label class='A'>Year</label></td>
				<td><label class='B'>:<%=student.getYear()%></label></td>
			</tr>
			<tr>
				<td><label class='A'>10th Per</label></td>
				<td><label class='B'>:<%=student.getPer10()%></label></td>
			</tr>
			<tr>
				<td><label class='A'>12th Per</label></td>
				<td><label class='B'>:<%=student.getPerc12()%></label></td>
			</tr>
			<tr>
				<td><label class='A'>DegreeCGPA</label></td>
				<td><label class='B'>:<%=student.getDegreePer()%></label></td>
			</tr>
			<tr>
				<td><label class='A'><a href="Update.jsp">Update</a></label></td>
				<td><label class='A'><a href="delete?phone=<%=student.getPhone()%>">Delete</a></label></td>
			</tr>
			<%
				} else {
					response.sendRedirect("index.jsp");
				}
			%>
		</table>
	</div>
	</div>
</body>
</html>