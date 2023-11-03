package com.servlet.classes;

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
import com.model.ClassX;
import com.model.Subject;
import com.service.classes.ClassServiceImpl;
import com.service.staff.AcademicStaffServiceImpl;
import com.service.subject.SubjectServiceImpl;

/**
 * Servlet implementation class ModifyClassServlet
 */
@WebServlet("/modify-class")
public class ModifyClassServlet extends HttpServlet {
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
			List<AcademicStaff> academicStaffs = AcademicStaffServiceImpl.getInstance().getAllAcademicStaffDetails();
			request.setAttribute("academicStaffs", academicStaffs);
			List<Subject> subjects = SubjectServiceImpl.getInstance().getAllSubjects();
			request.setAttribute("subjects", subjects);

			int classId = Integer.parseInt(request.getParameter("id"));
			ClassX classX = ClassServiceImpl.getInstance().getClassById(classId);
			request.setAttribute("classX", classX);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/modify-class.jsp");
			rd.forward(request, response);

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
			int classId = Integer.parseInt(request.getParameter("classId"));
			int subjectId = Integer.parseInt(request.getParameter("subjectId"));
			int academicStaffId = Integer.parseInt(request.getParameter("academicStaffId"));
			String className = request.getParameter("className");
			String allocatedClassroom = request.getParameter("allocatedClassroom");

			ClassX classX = new ClassX(classId, subjectId, academicStaffId, className, allocatedClassroom);
			Boolean isUpdated = ClassServiceImpl.getInstance().updateClass(classX);

			if (isUpdated) {
				response.sendRedirect("classes?modify=success");
			} else {
				response.sendRedirect("classes?modify=fail");
			}
		}
	}

}
