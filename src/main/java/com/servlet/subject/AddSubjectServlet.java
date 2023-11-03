package com.servlet.subject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.Subject;
import com.service.subject.SubjectServiceImpl;

/**
 * Servlet implementation class AddSyvjectServlet
 */
@WebServlet("/add-subject")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("admin") == null) {
			response.sendRedirect("admin-login");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/add-subject.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("admin") == null) {
			response.sendRedirect("admin-login");
		} else {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Subject subject = new Subject(name, description);
			boolean result = SubjectServiceImpl.getInstance().addSubject(subject);
			if (result) {
				response.sendRedirect("subjects?add=success");
			} else {
				response.sendRedirect("subjects?add=fail");
			}
		}
	}

}
