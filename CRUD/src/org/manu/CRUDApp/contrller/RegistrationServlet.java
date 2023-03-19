package org.manu.CRUDApp.contrller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.manu.CRUDApp.dao.StudentDao;
import org.manu.CRUDApp.dto.Student;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Enumeration<String> allfields = req.getParameterNames();
		ArrayList<String> al = new ArrayList<String>();
		RequestDispatcher dispatcher = null;
		while (allfields.hasMoreElements()) {
			al.add(req.getParameter(allfields.nextElement()));
		}
		boolean checking = checkallfeilds(al);
		if (checking) {
			String Email = req.getParameter("id");
			String Name = req.getParameter("nm");
			Long Phone = Long.parseLong(req.getParameter("pn"));
			String College = req.getParameter("co");
			String Dept = req.getParameter("de");
			String Year = req.getParameter("yr");
			double TenPerc = Double.parseDouble(req.getParameter("teper"));
			double TWPerc = Double.parseDouble(req.getParameter("twper"));
			double DegreePerc = Double.parseDouble(req.getParameter("deper"));
			String Password = req.getParameter("pas");
			String Gender = req.getParameter("ge");

			StudentDao studentDao = new StudentDao();
			PrintWriter out = res.getWriter();
			boolean result = studentDao.CheckRegistration(Email, Password);
			if (result == false) {
				Student student = new Student();
				student.setEmail(Email);
				student.setName(Name);
				student.setPhone(Phone);
				student.setCollage(College);
				student.setDept(Dept);
				student.setYear(Year);
				student.setPer10(TenPerc);
				student.setPerc12(TWPerc);
				student.setDegreePer(DegreePerc);
				student.setPassword(Password);
				student.setGender(Gender);
				int insert = new StudentDao().InsertStudent(student);
				System.out.println(insert + " Yes Record Inserted");
				out.println(
						"<h1 style='color: white; margin-left: 350px; margin-top: 20px;'>Congradulation!! You Successfully Registered</h1>"
								+ "<h1 style='color: white; margin-left: 380px; margin-top: 20px;'>Please Kindly Login for Further Operations</h>");
				dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, res);
				out.close();
			} else {
				out.println(
						"<h1 style='color: white; margin-left: 450px; margin-top: 100px;'>You Already Registered!! Just Login</h1>");
				dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, res);
				out.close();
			}
		} else {
			dispatcher = req.getRequestDispatcher("FillAllFieldsRegister.jsp");
			dispatcher.forward(req, res);
		}
	}

	private boolean checkallfeilds(ArrayList<String> al) {
		for (String i : al) {
			if (i.equals("")) {
				return false;
			}
		}
		return true;
	}
}