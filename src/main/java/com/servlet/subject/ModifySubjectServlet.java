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
 * Servlet implementation class ModifySubjectServlet
 */
@WebServlet("/modify-subject")
public class ModifySubjectServlet extends HttpServlet {
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
			int id = Integer.parseInt(request.getParameter("id"));
			Subject subject = SubjectServiceImpl.getInstance().getSubjectById(id);
			request.setAttribute("subject", subject);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/modify-subject.jsp");
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
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Subject subject = new Subject(id, name, description);
			boolean result = SubjectServiceImpl.getInstance().updateSubject(subject);
			if (result) {
				response.sendRedirect("subjects?modify=success");
			} else {
				response.sendRedirect("subjects?modify=fail");
			}
		}
	}

}
