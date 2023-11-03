package com.servlet.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.service.exam.ExamServiceImpl;

/**
 * Servlet implementation class DeleteSubjectServlet
 */
@WebServlet("/delete-exam")
public class DeleteExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("AcademicStaff") == null) {
			response.sendRedirect("academic-staff-login");
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean result = ExamServiceImpl.getInstance().deleteExam(id);
			if (result) {
				response.sendRedirect("exams?delete=success");
			} else {
				response.sendRedirect("exams?delete=fail");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
