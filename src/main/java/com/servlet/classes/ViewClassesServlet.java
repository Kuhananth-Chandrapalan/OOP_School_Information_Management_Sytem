package com.servlet.classes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.model.AcademicStaff;
import com.model.ClassX;
import com.model.Subject;
import com.service.classes.ClassServiceImpl;
import com.service.staff.AcademicStaffServiceImpl;
import com.service.subject.SubjectServiceImpl;

/**
 * Servlet implementation class ViewClassesServlet
 */
@WebServlet("/classes")
public class ViewClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AcademicStaff> academicStaffs = AcademicStaffServiceImpl.getInstance().getAllAcademicStaffDetails();
		request.setAttribute("academicStaffs", academicStaffs);
		List<Subject> subjects = SubjectServiceImpl.getInstance().getAllSubjects();
		request.setAttribute("subjects", subjects);
		List<ClassX> classes = ClassServiceImpl.getInstance().getClasses();
		request.setAttribute("classes", classes);
		
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

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/classes-list.jsp");
		rd.forward(request, response);
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
