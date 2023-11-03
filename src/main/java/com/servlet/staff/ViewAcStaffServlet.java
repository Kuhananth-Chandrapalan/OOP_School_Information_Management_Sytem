package com.servlet.staff;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.model.AcademicStaff;
import com.model.Subject;
import com.service.staff.AcademicStaffServiceImpl;
import com.service.subject.SubjectServiceImpl;

/**
 * Servlet implementation class ViewAcStaffServlet
 */
@WebServlet("/academic-staff")
public class ViewAcStaffServlet extends HttpServlet {
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
			List<Subject> subjects = SubjectServiceImpl.getInstance().getAllSubjects();
			request.setAttribute("subjects", subjects);

			List<AcademicStaff> academicStaffs = AcademicStaffServiceImpl.getInstance().getAllAcademicStaffDetails();
			request.setAttribute("academicStaffs", academicStaffs);
			
			// check for get parameter (return messages)
			if (request.getParameter("delete") != null) {
				request.setAttribute("delete", request.getParameter("delete"));
			}
			if (request.getParameter("modify") != null) {
				request.setAttribute("modify", request.getParameter("modify"));
			}
			if (request.getParameter("add") != null) {
				request.setAttribute("add", request.getParameter("add"));
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/academic-staff-list.jsp");
			dispatcher.forward(request, response);
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
