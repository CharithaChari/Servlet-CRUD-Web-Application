package org.manu.CRUDApp.contrller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manu.CRUDApp.dao.StudentDao;
import org.manu.CRUDApp.dto.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Student student = new Student();
		student.setEmail(req.getParameter("id"));
		student.setName(req.getParameter("nm"));
		student.setPhone(Long.parseLong(req.getParameter("pn")));
		student.setCollage(req.getParameter("co"));
		student.setDept(req.getParameter("de"));
		student.setYear(req.getParameter("yr"));
		student.setPer10(Double.parseDouble(req.getParameter("teper")));
		student.setPerc12(Double.parseDouble(req.getParameter("twper")));
		student.setDegreePer(Double.parseDouble(req.getParameter("deper")));
		student.setPassword(req.getParameter("pas"));
		student.setGender(req.getParameter("ge"));

		StudentDao studentDao = new StudentDao();
		int status = studentDao.updateStudent(student);
		System.out.println(status);
		HttpSession session = req.getSession();
		session.setAttribute("student", student);
		res.sendRedirect("Reading.jsp");
	}
}
