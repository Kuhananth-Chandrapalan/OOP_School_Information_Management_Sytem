package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.service.classes.ClassServiceImpl;
import com.service.staff.AcademicStaffServiceImpl;
import com.service.student.StudentServiceImpl;
import com.service.subject.SubjectServiceImpl;

/**
 * Servlet implementation class AdminDashboardServlet
 */
@WebServlet("/admin-dashboard")
public class AdminDashboardServlet extends HttpServlet {
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
			int studentsCount = StudentServiceImpl.getInstance().getStudentsCount();
			int teachersCount = AcademicStaffServiceImpl.getInstance().getAcademicStaffCount();
			int classCount = ClassServiceImpl.getInstance().getClassCount();
			int subjectCount = SubjectServiceImpl.getInstance().getSubjectsCount();
			request.setAttribute("studentsCount", studentsCount);
			request.setAttribute("teachersCount", teachersCount);
			request.setAttribute("classCount", classCount);
			request.setAttribute("subjectCount", subjectCount);
		
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/admin-dashboard.jsp");
			rd.forward(request, response);
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
