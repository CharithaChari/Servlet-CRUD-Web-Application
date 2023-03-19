<%@page import="org.manu.CRUDApp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="RegistrationCss.css">
</head>
<body>
	<%
		Student student = (Student) session.getAttribute("student");
		if (student != null) {
	%>
	<div class="login-box">
		<h2>Updation</h2>
		<form action="update" method="post">
			<div id="Manu">
				<div id="card1">
					<div class="user-box">
						<input type="email" value="<%=student.getEmail()%>" class="in"
							name="id" required=""> <label>Email</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getPassword()%>" class="in"
							name="pas" required=""> <label>Password</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getName()%>" class="in"
							name="nm" required=""> <label>Name</label>
					</div>

					<div class="user-box">
						<input type="number" value="<%=student.getPhone()%>" class="in"
							name="pn" required="" readonly="readonly"> <label>Phone</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getCollage()%>" class="in"
							name="co" required=""> <label>College</label>
					</div>

					<div class="manu">
						<label for="">Gender :</label> <input type="radio" name="ge"
							value="MALE">Male <input type="radio" name="ge"
							value="MALE">Female <input type="radio" name="ge"
							value="MALE">Other
					</div>

				</div>

				<div id="card2">

					<div class="user-box">
						<input type="text" value="<%=student.getDept()%>" class="in"
							name="de" required=""> <label>Department</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getYear()%>" class="in"
							name="yr" required=""> <label>Pass Out Year</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getPer10()%>" class="in"
							name="teper" required=""> <label>10th Percentege</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getPerc12()%>" class="in"
							name="twper" required=""> <label>12th Percentege</label>
					</div>

					<div class="user-box">
						<input type="text" value="<%=student.getDegreePer()%>" class="in"
							name="deper" required=""> <label>Degree CGPA</label>
					</div>
					
				</div>
			</div>
			<div id="Manu1">
				<input type="submit" value="UPDATE" id="A"> <span></span> <span></span>
				<span></span> <span></span>
			</div>
	</div>
	</form>
	</div>
	<%
		} else {
			response.sendRedirect("index.jsp");
		}
	%>
</body>
</html>