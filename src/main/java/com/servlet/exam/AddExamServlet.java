package com.servlet.exam;

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
import com.model.Exam;
import com.service.classes.ClassServiceImpl;
import com.service.exam.ExamServiceImpl;
import com.service.staff.AcademicStaffServiceImpl;

/**
 * Servlet implementation class AddSyvjectServlet
 */
@WebServlet("/new-exam")
public class AddExamServlet extends HttpServlet {
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
			List<ClassX> classes = ClassServiceImpl.getInstance().getClasses();
			request.setAttribute("classes", classes);
			List<AcademicStaff> academicStaffs = AcademicStaffServiceImpl.getInstance().getAllAcademicStaffDetails();
			request.setAttribute("academicStaffs", academicStaffs);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/add-exam.jsp");
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
		if (session == null || session.getAttribute("AcademicStaff") == null) {
			response.sendRedirect("academic-staff-login");
		} else {
			int classId = Integer.parseInt(request.getParameter("classId"));
			int academicStaffId = Integer.parseInt(request.getParameter("academicStaffId"));
			String name = request.getParameter("name");
			Exam exam = new Exam(classId, academicStaffId, name);
			boolean result = ExamServiceImpl.getInstance().addExam(exam);
			if (result) {
				response.sendRedirect("exams?add=success");
			} else {
				response.sendRedirect("exams?add=fail");
			}
		}
	}

}
