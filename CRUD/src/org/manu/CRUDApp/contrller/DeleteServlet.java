package org.manu.CRUDApp.contrller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manu.CRUDApp.dao.StudentDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long Phone = Long.parseLong(req.getParameter("phone"));
		int status = new StudentDao().DeleteStudent(Phone);
		System.out.println(status + "Yes Record is deleted");
		HttpSession session = req.getSession();
		session.invalidate();
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.include(req, resp);
	}
}
