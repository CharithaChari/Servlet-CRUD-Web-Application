package org.manu.CRUDApp.contrller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manu.CRUDApp.dao.StudentDao;
import org.manu.CRUDApp.dto.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String Email = req.getParameter("em");
		String Password = req.getParameter("ps");
		RequestDispatcher dispatcher = null;

		if ((Password == "" && Email == "") == false) {
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.LoginStudent(Email, Password);

			HttpSession session = req.getSession();
			session.setAttribute("student", student);

			if (student != null) {
				dispatcher = req.getRequestDispatcher("Reading.jsp");
				dispatcher.forward(req, res);
			} else {
				PrintWriter out = res.getWriter();
				out.println(
						"<h1 style='color: white; margin-left: 250px; margin-top: 100px;'>Sorry Your not Registered yet!! Please Kindly Registered "
								+ "<a href='Register.jsp'>REGISTER</a></h1>");
				dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, res);
				out.close(); 
			}
		} else {
			PrintWriter out = res.getWriter();
			out.println(
					"<h1 style='color: white; margin-left: 250px; margin-top: 100px;'>Please Kindly Fill All the Form Feilds !!! </h1>");
			dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, res);
			out.close();
		}
	}
}
